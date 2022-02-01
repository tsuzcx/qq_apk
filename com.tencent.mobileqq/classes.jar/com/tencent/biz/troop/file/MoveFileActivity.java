package com.tencent.biz.troop.file;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.troop.file.protocol.TroopFileCreateFolderObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class MoveFileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected long a;
  protected String b;
  int c = 0;
  boolean d = false;
  private String e;
  private String f;
  private String g;
  private XListView h;
  private ArrayList<TroopFileInfo> i = new ArrayList();
  private MoveFileActivity.FolderListAdapter j = new MoveFileActivity.FolderListAdapter(this, null);
  private Button k;
  private View l;
  private TextView m;
  private TroopFileManager n;
  private int o = -1;
  private int p = 15;
  private boolean q;
  private int r = 0;
  private int s = 0;
  private ByteStringMicro t = ByteStringMicro.copyFromUtf8("");
  private TroopFileGetFileListObserver u = new MoveFileActivity.3(this);
  private TroopFileCreateFolderObserver v = new MoveFileActivity.8(this);
  private QQProgressDialog w;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", MoveFileActivity.class.getName());
    localIntent.putExtra("troop_uin", paramString1);
    paramContext = paramString2;
    if (paramString2 == null) {
      paramContext = "/";
    }
    localIntent.putExtra("folder_id", paramContext);
    localIntent.putExtra("file_id", paramString3);
    localIntent.putExtra("file_name", paramString4);
    return localIntent;
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = this.e.equals("/");
    boolean bool1 = true;
    if (!bool2)
    {
      if (paramInt < this.i.size() - 1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void c()
  {
    a();
  }
  
  public void a()
  {
    TroopFileProtocol.a(this.app, this.a, this.r, 0, this.p, 3, 1, "/", 1, 0L, this.s, this.t, this.u);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.w == null) {
        this.w = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.w.c(paramInt);
      this.w.c(false);
      this.w.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, localException.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = InputDialog.a(this, paramString1, "", 2131887648, 2131888010, new MoveFileActivity.4(this), new MoveFileActivity.5(this));
    paramString2 = paramString1.getEditText();
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2.setText(paramString3);
    }
    paramString2.setFilters(new InputFilter[] { new InputFilter.LengthFilter(48) });
    paramString2.setHint(2131895392);
    paramString2.addTextChangedListener(new MoveFileActivity.6(this, paramString2, paramString1));
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.a(paramString4, -65536);
    }
    paramString1.getBtnight().setEnabled(false);
    paramString1.getBtnight().setTextColor(getResources().getColor(2131165998));
    paramString1.show();
    new Handler(getMainLooper()).post(new MoveFileActivity.7(this, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h.getFirstVisiblePosition() == 0)
    {
      this.l.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.l.setVisibility(8);
      return;
    }
    this.l.setVisibility(0);
    this.m.setText(2131916801);
    Drawable localDrawable = getResources().getDrawable(2130839585);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.m.setCompoundDrawables(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  public void b()
  {
    try
    {
      if ((this.w != null) && (this.w.isShowing()))
      {
        this.w.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, localException.toString());
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    Object localObject = paramBundle.getString("troop_uin");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      finish();
      return false;
    }
    this.a = Long.valueOf((String)localObject).longValue();
    this.e = paramBundle.getString("folder_id");
    if (TextUtils.isEmpty(this.e))
    {
      finish();
      return false;
    }
    this.g = paramBundle.getString("file_name");
    if (TextUtils.isEmpty(this.g))
    {
      finish();
      return false;
    }
    this.f = paramBundle.getString("file_id");
    if (TextUtils.isEmpty(this.f))
    {
      finish();
      return false;
    }
    this.n = TroopFileManager.a(this.app, this.a);
    paramBundle = (LayoutInflater)getSystemService("layout_inflater");
    localObject = paramBundle.inflate(2131626692, null);
    this.h = ((XListView)((View)localObject).findViewById(2131431170));
    this.h.setVerticalScrollBarEnabled(false);
    this.h.setDivider(null);
    this.h.setFocusable(false);
    this.h.setOnItemClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131431501);
    this.k = ((Button)((View)localObject).findViewById(2131431218));
    localTextView.setOnClickListener(this);
    this.k.setOnClickListener(this);
    setContentView((View)localObject);
    setTitle(2131895382);
    localTextView = (TextView)findViewById(2131436211);
    localTextView.setText(2131887648);
    localTextView.setOnClickListener(this);
    localTextView.setVisibility(0);
    this.leftView.setVisibility(8);
    localObject = (TextView)((View)localObject).findViewById(2131433141);
    TextUtils.ellipsize(this.g, ((TextView)localObject).getPaint(), AIOUtils.b(230.0F, getResources()), TextUtils.TruncateAt.MIDDLE, false, new MoveFileActivity.1(this, (TextView)localObject));
    this.l = paramBundle.inflate(2131626697, null);
    this.l.findViewById(2131441536).setBackgroundResource(2130838958);
    this.h.addFooterView(this.l);
    this.l.setVisibility(8);
    this.m = ((TextView)this.l.findViewById(2131441537));
    this.m.setTextColor(getResources().getColor(2131167993));
    this.h.setOnScrollListener(this.j);
    this.h.setAdapter(this.j);
    c();
    ReportController.b(this.app, "P_CliOper", "Grp_files", "", "file", "move_file", 0, 0, Long.toString(this.a), "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    TroopFileInfo localTroopFileInfo;
    if (i1 != 2131431218)
    {
      if (i1 != 2131431501)
      {
        if (i1 == 2131436211)
        {
          ReportController.b(this.app, "P_CliOper", "Grp_files", "", "file", "move_cancel", 0, 0, Long.toString(this.a), "", "", "");
          finish();
          overridePendingTransition(0, 2130772018);
        }
      }
      else if (TroopFileUtils.a(this.app, this, this.a) != 0) {
        a(getResources().getString(2131895312), null, this.b, "");
      }
    }
    else
    {
      localTroopFileInfo = (TroopFileInfo)this.i.get(this.o);
      if (this.e.equals(localTroopFileInfo.c))
      {
        finish();
        overridePendingTransition(0, 2130772018);
      }
    }
    try
    {
      if (TroopFileUtils.a(this.app, this, this.a) != 0)
      {
        TroopFileProtocol.a(this.app, this.a, localTroopFileInfo.f, this.f, this.e, localTroopFileInfo.c, new MoveFileActivity.2(this, localTroopFileInfo));
        a(2131895383);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label227:
      break label227;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == this.o) {
      return;
    }
    this.k.setEnabled(true);
    this.k.setBackgroundResource(2130839481);
    this.k.setTextAppearance(getActivity(), 2131952356);
    this.o = paramInt;
    this.j.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity
 * JD-Core Version:    0.7.0.1
 */