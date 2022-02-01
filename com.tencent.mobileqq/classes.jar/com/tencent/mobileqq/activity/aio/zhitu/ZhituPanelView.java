package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.XEditTextEx;

public class ZhituPanelView
  extends RichTextPanelView
{
  public static int a = 6;
  private static String f = "ZhituManager.PanelView";
  private static String g = HardCodeUtil.a(2131913939);
  BaseChatPie b;
  GridLayoutManager c;
  RichTextPanelRecyclerView d;
  TextView e;
  private int h;
  private int i;
  private ZhituPanelView.ZhituPanelAdapter j;
  private ColorDrawable k = new ColorDrawable();
  private ZhituPicData l;
  private Button m;
  private RichTextPanelExtendHelper n;
  
  public ZhituPanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper, Button paramButton)
  {
    super(paramContext);
    this.b = paramBaseChatPie;
    this.m = paramButton;
    setClipToPadding(false);
    this.h = (ViewUtils.getScreenWidth() / 3);
    this.i = (this.h - ViewUtils.dpToPx(2.0F));
    this.n = paramRichTextPanelExtendHelper;
    a();
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131450397);
    localTextView.setText(paramString);
    localTextView.setTextColor(Color.parseColor("#878B99"));
    localTextView.setTextSize(2, 14.0F);
    localTextView.setGravity(17);
    localTextView.setVisibility(8);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    return localTextView;
  }
  
  private View d()
  {
    RichTextChatManager localRichTextChatManager = RichTextChatManager.a(this.b.i());
    g = localRichTextChatManager.b();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localRichTextChatManager.d())
    {
      this.e = new TextView(getContext());
      this.e.setId(2131450399);
      this.e.setText(localRichTextChatManager.c());
      this.e.setTextColor(-8947849);
      this.e.setTextSize(2, 14.0F);
      this.e.setPadding(0, AIOUtils.b(8.0F, getResources()), 0, AIOUtils.b(6.0F, getResources()));
      this.e.setGravity(1);
      localLinearLayout.addView(this.e);
    }
    localLinearLayout.addView(a(""), new LinearLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
  
  public void a()
  {
    View localView = d();
    this.d = new RichTextPanelRecyclerView(getContext());
    this.d.setOverScrollMode(0);
    this.c = new GridLayoutManager(getContext(), 3);
    this.d.setLayoutManager(this.c);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131450399);
    addView(this.d, localLayoutParams);
    this.j = new ZhituPanelView.ZhituPanelAdapter(this);
    this.d.setAdapter(this.j);
    if (localView != null) {
      this.j.a(localView);
    }
    this.d.addOnScrollListener(new ZhituPanelView.ZhituOnScrollListener(this));
    this.d.setPanelExtendHelper(this.n);
  }
  
  public void a(boolean paramBoolean)
  {
    ZhituManager localZhituManager = ZhituManager.a(this.b.d);
    if (paramBoolean)
    {
      localZhituManager.c = this;
      localZhituManager.e = this.j;
      localZhituManager.a(this.b.d, this.b.Y.getText(), this.b.V.a(), this.b.F(), false);
      return;
    }
    localZhituManager.c = null;
    localZhituManager.e = null;
  }
  
  public void b()
  {
    ZhituPicData localZhituPicData = this.l;
    if ((localZhituPicData != null) && (localZhituPicData.a != null))
    {
      if (localZhituPicData.l == null) {
        return;
      }
      ThreadManager.post(new ZhituPanelView.1(this, localZhituPicData), 8, null, false);
      ZhituManager.a(this.b.d).a(localZhituPicData);
      ReportController.b(this.b.d, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
      this.b.Y.setText("");
      this.b.aF();
    }
  }
  
  public String getName()
  {
    return g;
  }
  
  public Button getSendView()
  {
    return this.m;
  }
  
  public int getZhituUIStyle()
  {
    BaseChatPie localBaseChatPie = this.b;
    if (localBaseChatPie != null) {
      return RichTextChatManager.a(localBaseChatPie.i()).e();
    }
    return 0;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ZhituManager localZhituManager = ZhituManager.a(this.b.d);
    localZhituManager.c = null;
    localZhituManager.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */