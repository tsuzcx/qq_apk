package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import agej;
import alxn;
import alxo;
import alxp;
import alxq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import anzj;
import bhlo;
import bhmi;
import bhnv;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import wjs;
import wkf;
import wow;
import woy;
import wrz;
import wsc;
import wsh;
import wsi;
import wth;
import xcw;
import xeq;
import yup;
import yuq;
import zhe;
import zho;
import zhp;
import zhq;
import zhr;
import zom;

@TargetApi(11)
public class P2VEditMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, wjs, woy<xcw, xeq>, zhp
{
  private static final String jdField_a_of_type_JavaLangString = P2VEditMusicDialog.class.getSimpleName();
  public int a;
  protected long a;
  public alxq a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public MusicHorizontalSeekView a;
  protected P2VEditMusicDialog.MusicPlayTask a;
  public ArrayList<zhr> a;
  protected HashMap<String, String> a;
  protected Timer a;
  protected wkf a;
  private wsh<wsc> jdField_a_of_type_Wsh = new alxp(this);
  private zhe jdField_a_of_type_Zhe;
  public zho a;
  public zhr a;
  public boolean a;
  public int b;
  protected long b;
  public View b;
  public TextView b;
  protected HashMap<String, Long> b;
  protected int c;
  protected View c;
  protected TextView c;
  protected volatile int d;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  
  public P2VEditMusicDialog(Context paramContext, alxq paramalxq, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 2131755166);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new alxo(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Alxq = paramalxq;
    this.jdField_a_of_type_Zhe = new zhe(paramContext, new alxn(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.width = -1;
    paramContext.height = -1;
    paramContext.windowAnimations = 2131755184;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { bhlo.a(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771979, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Alxq.a(this.jdField_a_of_type_Zhr);
    if (this.jdField_a_of_type_Zhr != null)
    {
      if (this.jdField_a_of_type_Zhr.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_Zhr.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Zhr.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_Alxq.a(zhr.jdField_b_of_type_Zhr);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_Alxq.a(zhr.jdField_b_of_type_Zhr);
  }
  
  private void h()
  {
    zhr localzhr = this.jdField_a_of_type_Alxq.a();
    if ((localzhr == null) || (this.jdField_a_of_type_Zhr == null) || ((localzhr.jdField_b_of_type_Int != 3) && (localzhr.jdField_b_of_type_Int != 2))) {}
    for (;;)
    {
      dismiss();
      return;
      if (localzhr.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Zhr.jdField_a_of_type_JavaLangString)) {}
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Alxq.d();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int < 5000) {
      return 5000;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    f();
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = (int)(this.jdField_c_of_type_AndroidWidgetTextView.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561789, null);
    super.setContentView((View)localObject);
    boolean bool;
    if (this.jdField_a_of_type_Int < 5000)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131371554));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131371538);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131371540));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371541));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377249));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377248));
      this.e = ((TextView)super.findViewById(2131371550));
      this.f = ((TextView)super.findViewById(2131371551));
      this.e.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366014));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377296);
      if (!this.jdField_a_of_type_Alxq.b()) {
        break label459;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131371539));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365616);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidWidgetGridView;
      if (this.jdField_a_of_type_Alxq.c()) {
        break label454;
      }
      bool = true;
      label317:
      this.jdField_a_of_type_Zho = new zho(paramContext, (GridView)localObject, bool, true);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Zho);
      this.jdField_a_of_type_Zho.a(null);
      label351:
      if (this.jdField_a_of_type_Alxq.a() == null) {
        break label497;
      }
      this.jdField_a_of_type_Zhr = new zhr();
      this.jdField_a_of_type_Zhr.a(this.jdField_a_of_type_Alxq.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = zhr.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (!bhnv.d(getContext())) {
        break label513;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramContext = new xcw();
      wow.a().a(paramContext, this);
      return;
      this.jdField_a_of_type_Long = 1000L;
      break;
      label454:
      bool = false;
      break label317;
      label459:
      ((View)localObject).findViewById(2131365536).getLayoutParams().height = agej.a(138.0F, paramContext.getResources());
      ((View)localObject).findViewById(2131371542).setVisibility(8);
      break label351;
      label497:
      this.jdField_a_of_type_Zhr = this.jdField_a_of_type_Alxq.a();
    }
    label513:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), anzj.a(2131706739), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = zhq.a(paramString);
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDownloadFinish() url = " + paramString);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, str);
      zhr localzhr = this.jdField_a_of_type_Alxq.a();
      if ((localzhr != null) && (paramString.equals(localzhr.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Alxq.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(localzhr.jdField_a_of_type_JavaLangString, str).apply();
      }
      yup.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue();
        paramString = new StringBuffer("onDownloadFinish errCode = ").append(paramInt).append(", name = ").append(zom.b(paramString)).append(", downloadTime = ").append(System.currentTimeMillis() - l).append(", fileSize = ").append(zom.a(str)).append(", url = " + paramString);
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
      }
      return;
      yup.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      yuq.a("0X80076D9");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.jdField_d_of_type_Int * 0.05F)
    {
      this.jdField_d_of_type_Int += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress() mIndex = " + this.jdField_d_of_type_Int + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.jdField_d_of_type_Int = 0;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  public void a(xcw paramxcw, xeq paramxeq, ErrorMessage paramErrorMessage)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.jdField_b_of_type_Long).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label203;
      }
    }
    label203:
    for (paramxcw = "null";; paramxcw = paramErrorMessage.getErrorMessage())
    {
      QLog.d(str, 2, paramxcw);
      yup.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramxcw = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramxcw.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramxcw);
      yup.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramxeq = paramxeq.a;
    int j = paramxeq.music_config.size();
    paramxcw = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramxcw.add(new zhr((qqstory_struct.MusicConfigInfo)paramxeq.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramxeq = new StringBuffer();
        paramxeq.append("GetMusicConfigResponse size = " + j);
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (zhr)paramxcw.get(i);
          paramxeq.append(", " + i + ": title = " + paramErrorMessage.jdField_b_of_type_JavaLangString + ", audioUrl = " + paramErrorMessage.jdField_d_of_type_JavaLangString);
          i += 1;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramxeq.toString());
      }
    }
    for (;;)
    {
      yup.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_JavaUtilArrayList = paramxcw;
      zhr.a(getContext(), paramxcw);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(zhr paramzhr)
  {
    String str2 = paramzhr.jdField_d_of_type_JavaLangString;
    String str1 = paramzhr.g;
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
    {
      paramzhr = str1;
      if (!zom.e(str1))
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
        paramzhr = str1;
        if (!zom.e(str1)) {
          paramzhr = zhq.a(str2);
        }
      }
      if (zom.e(paramzhr))
      {
        if ((this.jdField_a_of_type_Wkf != null) && (this.jdField_a_of_type_Wkf.a()))
        {
          bhmi.d(this.jdField_a_of_type_Wkf.a());
          this.jdField_a_of_type_Wkf.a();
        }
        if (this.jdField_a_of_type_Alxq.a() != null)
        {
          this.jdField_a_of_type_Alxq.a(paramzhr);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "exists audio_url = " + str2 + ", path = " + paramzhr);
          return;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "getCurFragmentMusic - urMusic is null");
        }
      }
      if (!bhnv.g(BaseApplication.getContext()))
      {
        f();
        QQToast.a(BaseApplication.getContext(), 2131694659, 0).a();
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramzhr);
      if ((this.jdField_a_of_type_Wkf != null) && (this.jdField_a_of_type_Wkf.a()))
      {
        bhmi.d(this.jdField_a_of_type_Wkf.a());
        this.jdField_a_of_type_Wkf.a();
      }
      ThreadManager.post(new P2VEditMusicDialog.3(this, str2), 5, null, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_Alxq.b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = 1000;
    int j = (paramInt2 - paramInt1) / 1000 * 1000;
    if (j < 1000) {}
    for (;;)
    {
      j = i;
      if (this.jdField_c_of_type_Int == 1)
      {
        j = i;
        if (i > 8500.0D)
        {
          j = i;
          if (i < 13500.0D) {
            j = 10000;
          }
        }
      }
      i = j + paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(zhq.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(zhq.a(i, true));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    zhr localzhr = this.jdField_a_of_type_Alxq.a();
    if (localzhr != null)
    {
      localzhr.jdField_d_of_type_Int = ((int)(localzhr.f * (paramInt3 / paramInt1)));
      localzhr.e = (localzhr.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      b(localzhr.jdField_d_of_type_Int, localzhr.e);
    }
  }
  
  public void b(zhr paramzhr)
  {
    if ((!TextUtils.isEmpty(paramzhr.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramzhr.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramzhr.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Alxq.a(paramzhr);
    a(paramzhr);
    yuq.a("0X80076D6");
  }
  
  public void c()
  {
    this.jdField_a_of_type_Alxq.c();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    c();
  }
  
  public void d()
  {
    e();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = new P2VEditMusicDialog.MusicPlayTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_Zhe.a();
    if ((this.jdField_a_of_type_Wkf != null) && (this.jdField_a_of_type_Wkf.a()))
    {
      bhmi.d(this.jdField_a_of_type_Wkf.a());
      this.jdField_a_of_type_Wkf.a();
    }
    ((wrz)((wsi)wth.a(20)).a(1)).b(this.jdField_a_of_type_Wsh);
    e();
    c();
    super.dismiss();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = null;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  protected void f()
  {
    zhr localzhr = this.jdField_a_of_type_Alxq.a();
    if ((localzhr != null) && (localzhr.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Zho != null) && (this.jdField_a_of_type_Zho.a(localzhr) > 0) && (!localzhr.equals(this.jdField_a_of_type_Zho.a())))
    {
      this.jdField_a_of_type_Zho.a(localzhr);
      this.jdField_a_of_type_Zho.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void onBackPressed()
  {
    g();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      g();
      dismiss();
      continue;
      h();
      continue;
      h();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    zhr localzhr;
    if (this.jdField_a_of_type_Zho != null)
    {
      localzhr = (zhr)this.jdField_a_of_type_Zho.getItem(paramInt);
      if (localzhr != null) {
        break label70;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onItemClick error musicInfo = " + null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label70:
      this.jdField_a_of_type_Zho.a(localzhr);
      this.jdField_a_of_type_Zho.notifyDataSetChanged();
      if (paramInt < this.jdField_a_of_type_Zho.a())
      {
        b();
        if (localzhr.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Alxq.a(localzhr);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        }
        else if (localzhr.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_Alxq.a(localzhr);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        }
        else if (localzhr.jdField_b_of_type_Int == 2)
        {
          if (!bhnv.g(BaseApplication.getContext()))
          {
            f();
            QQToast.a(BaseApplication.getContext(), 2131694659, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Alxq.a();
            if ((!this.jdField_a_of_type_Alxq.a()) && ((getContext() instanceof ContextThemeWrapper)) && ((((ContextThemeWrapper)getContext()).getBaseContext() instanceof Activity))) {
              a((Activity)((ContextThemeWrapper)getContext()).getBaseContext());
            }
          }
        }
      }
      else
      {
        b();
        if (!TextUtils.isEmpty(localzhr.jdField_d_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localzhr.jdField_b_of_type_JavaLangString);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Alxq.a(localzhr);
        a(localzhr);
        yup.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */