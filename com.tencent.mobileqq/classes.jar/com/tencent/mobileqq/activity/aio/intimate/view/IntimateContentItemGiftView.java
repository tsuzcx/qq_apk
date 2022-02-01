package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonBody;
import com.tencent.mobileqq.data.IntimateInfo.FriendGiftInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.Iterator;
import java.util.List;

public class IntimateContentItemGiftView
  extends IntimateContentItemBaseView
{
  private View i;
  private TextView j;
  private TextView k;
  private HorizontalListView l;
  private IntimateContentItemGiftView.FriendGiftAdapter m;
  private boolean n = false;
  private int o = 1;
  
  public IntimateContentItemGiftView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemGiftView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemGiftView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131433771) {
      return;
    }
    paramView = new Intent(this.h.l(), QQBrowserActivity.class);
    String str = this.d.friendGiftInfo.str_custom_url;
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("goToFriendGiftWebPage, url: %s", new Object[] { str }));
    }
    paramView.putExtra("url", str);
    paramView.putExtra("finish_animation_out_to_right", true);
    paramView.putExtra("is_wrap_content", true);
    paramView.putExtra("hide_left_button", false);
    if (this.h.l() != null) {
      this.h.l().startActivity(paramView);
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3B4", "0X800A3B4", this.o, 0, "", "", "", "");
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.j.setText(String.valueOf(paramIntimateInfo.friendGiftInfo.str_send_times));
    this.k.setText(paramIntimateInfo.friendGiftInfo.str_desc);
    if (paramIntimateInfo.friendGiftInfo.str_gift_url.size() > 6) {
      this.m.a(paramIntimateInfo.friendGiftInfo.str_gift_url.subList(0, 6));
    } else {
      this.m.a(paramIntimateInfo.friendGiftInfo.str_gift_url);
    }
    if (this.n) {
      ReportController.b(null, "dc00898", "", "", "0X800A3B3", "0X800A3B3", this.o, 0, "", "", "", "");
    }
  }
  
  protected boolean a()
  {
    if ((this.d != null) && (this.d.commonBodyList != null) && (this.d.commonBodyList.size() > 0))
    {
      Iterator localIterator = this.d.commonBodyList.iterator();
      while (localIterator.hasNext())
      {
        IntimateInfo.CommonBody localCommonBody = (IntimateInfo.CommonBody)localIterator.next();
        if (localCommonBody.cmd == 3436)
        {
          this.d.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom(localCommonBody);
          if ((this.d.friendGiftInfo != null) && (this.d.friendGiftInfo.str_send_times > 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  protected void b()
  {
    View localView = LayoutInflater.from(this.a).inflate(2131625176, this, true);
    this.i = localView.findViewById(2131433771);
    this.j = ((TextView)localView.findViewById(2131433772));
    this.l = ((HorizontalListView)localView.findViewById(2131433775));
    this.k = ((TextView)localView.findViewById(2131433774));
    this.m = new IntimateContentItemGiftView.FriendGiftAdapter(this, null);
    this.l.setDividerWidth(ViewUtils.dip2px(5.0F));
    this.l.setAdapter(this.m);
    this.i.setOnClickListener(this);
    this.l.setOnTouchListener(this);
    this.l.setTransTouchStateToParent(true);
    this.i.setOnTouchListener(this);
  }
  
  public void setNeedReportPage(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setReportType(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemGiftView
 * JD-Core Version:    0.7.0.1
 */