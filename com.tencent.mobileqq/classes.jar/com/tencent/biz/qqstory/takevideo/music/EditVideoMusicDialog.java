package com.tencent.biz.qqstory.takevideo.music;

import agej;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
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
import bhlq;
import bhmi;
import bhnv;
import bhpc;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
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
import yxt;
import yyf;
import zhb;
import zhe;
import zhi;
import zhj;
import zhk;
import zhl;
import zhm;
import zho;
import zhp;
import zhq;
import zhr;
import zom;
import zps;

@TargetApi(11)
public class EditVideoMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, wjs, woy<xcw, xeq>, zhp
{
  public int a;
  protected long a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public EditVideoMusic a;
  protected EditVideoParams a;
  protected EditVideoMusicDialog.MusicPlayTask a;
  public MusicHorizontalSeekView a;
  protected Timer a;
  protected ConcurrentHashMap<String, String> a;
  protected wkf a;
  private wsh<wsc> jdField_a_of_type_Wsh = new zhm(this);
  public zhb a;
  private zhe jdField_a_of_type_Zhe;
  public zho a;
  public zhr a;
  public final boolean a;
  public int b;
  protected long b;
  public View b;
  public TextView b;
  protected ConcurrentHashMap<String, Long> b;
  public boolean b;
  protected int c;
  protected View c;
  protected TextView c;
  public boolean c;
  protected int d;
  protected TextView d;
  protected boolean d;
  protected int e;
  protected TextView e;
  protected volatile int f;
  protected TextView f;
  
  public EditVideoMusicDialog(Context paramContext, EditVideoMusic paramEditVideoMusic, boolean paramBoolean1, int paramInt, EditVideoParams paramEditVideoParams, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, 2131755166);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new zhj(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Zhe = new zhe(paramContext, new zhi(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.height = zps.d(getContext());
    paramContext.windowAnimations = 2131755184;
    paramContext.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "pressCancelBtn");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(this.jdField_a_of_type_Zhr);
    if (this.jdField_a_of_type_Zhr != null)
    {
      this.jdField_a_of_type_Zhr.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_Zhr.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(zhr.jdField_b_of_type_Zhr);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(zhr.jdField_b_of_type_Zhr);
  }
  
  private void g()
  {
    int j = 1;
    zhr localzhr = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    int i = j;
    if (localzhr != null)
    {
      i = j;
      if (this.jdField_a_of_type_Zhr != null)
      {
        if ((localzhr.jdField_b_of_type_Int == 3) || (localzhr.jdField_b_of_type_Int == 2)) {
          break label108;
        }
        i = j;
      }
    }
    while ((this.jdField_d_of_type_Boolean) && (i != 0))
    {
      bhlq.a(getContext(), 230).setMessage(anzj.a(2131702680)).setPositiveButton(anzj.a(2131702661), new zhl(this)).setNegativeButton(anzj.a(2131702604), new zhk(this)).show();
      return;
      label108:
      i = j;
      if (localzhr.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Zhr.jdField_a_of_type_JavaLangString)) {
        i = 0;
      }
    }
    dismiss();
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
    e();
    c();
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
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "2";; str = "1")
    {
      yup.a("video_edit", "cut_music", 0, 0, new String[] { str, "", "", "" });
      yuq.a("0X80076DA");
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561789, null);
    super.setContentView((View)localObject);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 4);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131371554));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131371538);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131371540));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371541));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377249));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377248));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371550));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371551));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366014));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377296);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b()) {
        break label575;
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
      this.jdField_a_of_type_Zho = new zho(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_a_of_type_Boolean, a(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Zho);
      this.jdField_a_of_type_Zho.a(null);
      label340:
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if (localObject == null)
      {
        EditVideoMusic localEditVideoMusic = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
        if (!this.jdField_a_of_type_Boolean) {
          break label616;
        }
        paramContext = zhr.jdField_a_of_type_Zhr;
        label369:
        localEditVideoMusic.a(paramContext);
      }
      this.jdField_a_of_type_Zhr = ((zhr)localObject);
      this.jdField_d_of_type_Int = ((zhr)localObject).jdField_d_of_type_Int;
      this.jdField_e_of_type_Int = ((zhr)localObject).jdField_e_of_type_Int;
      this.jdField_c_of_type_Boolean = yxt.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 512);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Zhb = new zhb(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams, this.jdField_a_of_type_AndroidOsHandler);
      }
      if (a(this.jdField_c_of_type_Int)) {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          break label623;
        }
      }
    }
    label575:
    label616:
    label623:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = zhr.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (i != 0)
      {
        if (!bhnv.d(getContext())) {
          break label628;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        paramContext = new xcw();
        wow.a().a(paramContext, this);
      }
      return;
      if (this.jdField_a_of_type_Int < 5000)
      {
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
        break;
      }
      this.jdField_a_of_type_Long = 1000L;
      break;
      ((View)localObject).findViewById(2131365536).getLayoutParams().height = agej.a(138.0F, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a());
      ((View)localObject).findViewById(2131371542).setVisibility(8);
      break label340;
      paramContext = zhr.jdField_b_of_type_Zhr;
      break label369;
    }
    label628:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), anzj.a(2131702659), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = zhq.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, new Object[] { "onDownloadFinish() url:", paramString, " errCode:", Integer.valueOf(paramInt) });
    }
    Object localObject;
    if (paramInt == 0)
    {
      this.jdField_f_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, str);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString.equals(((zhr)localObject).jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((zhr)localObject).jdField_a_of_type_JavaLangString, str).commit();
      }
      yup.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + zom.b(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + zom.a(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString != null) && (paramString.equals(((zhr)localObject).jdField_d_of_type_JavaLangString)))
      {
        if (paramInt != 6)
        {
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, getContext().getResources().getString(2131697599));
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        }
        f();
      }
      yup.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      yuq.a("0X80076D9");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.jdField_f_of_type_Int * 0.05F)
    {
      this.jdField_f_of_type_Int += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onProgress() mIndex = " + this.jdField_f_of_type_Int + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.jdField_f_of_type_Int = 0;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  public void a(xcw paramxcw, xeq paramxeq, ErrorMessage paramErrorMessage)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.jdField_b_of_type_Long).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label205;
      }
    }
    label205:
    for (paramxcw = "null";; paramxcw = paramErrorMessage.getErrorMessage())
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, paramxcw);
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
    paramxcw = paramxeq.a;
    int j = paramxcw.music_config.size();
    paramxeq = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramxeq.add(new zhr((qqstory_struct.MusicConfigInfo)paramxcw.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "GetMusicConfigResponse size = " + j);
      }
    }
    for (;;)
    {
      yup.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = paramxeq;
      zhr.a(getContext(), paramxeq);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(zhr paramzhr)
  {
    String str = paramzhr.jdField_d_of_type_JavaLangString;
    Object localObject = paramzhr.g;
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramzhr = (zhr)localObject;
      if (!zom.e((String)localObject)) {
        paramzhr = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      localObject = paramzhr;
      if (!zom.e(paramzhr)) {
        localObject = zhq.a(str);
      }
      if (!zom.e((String)localObject)) {
        break label171;
      }
      if ((this.jdField_a_of_type_Wkf != null) && (this.jdField_a_of_type_Wkf.a()))
      {
        bhmi.d(this.jdField_a_of_type_Wkf.a());
        this.jdField_a_of_type_Wkf.a();
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a() != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "exists audio_url = " + str + ", path = " + (String)localObject);
      }
    }
    return;
    label171:
    if (!bhnv.g(BaseApplication.getContext()))
    {
      e();
      QQToast.a(BaseApplication.getContext(), 2131694659, 0).a();
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    if ((this.jdField_a_of_type_Wkf != null) && (this.jdField_a_of_type_Wkf.a()))
    {
      bhmi.d(this.jdField_a_of_type_Wkf.a());
      this.jdField_a_of_type_Wkf.a();
    }
    ThreadManager.post(new EditVideoMusicDialog.3(this, str), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    d();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.j();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.k();
    zhr localzhr = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    yyf localyyf;
    if (localzhr != null)
    {
      localyyf = (yyf)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Yxt.a(yyf.class);
      if (localyyf != null) {
        if ((localzhr.jdField_b_of_type_Int != 2) && (localzhr.jdField_b_of_type_Int != 3) && (localzhr.jdField_b_of_type_Int != 0)) {
          break label88;
        }
      }
    }
    label88:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localyyf.a(paramBoolean);
      return;
    }
  }
  
  protected boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 5) {
      bool = false;
    }
    return bool;
  }
  
  protected void b()
  {
    d();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.i();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.l();
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
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(zhq.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(zhq.a(i, false));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    zhr localzhr = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if (localzhr != null)
    {
      paramInt2 = localzhr.jdField_f_of_type_Int;
      localzhr.jdField_d_of_type_Int = ((int)(paramInt2 * (paramInt3 / paramInt1)));
      localzhr.jdField_e_of_type_Int = (localzhr.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      if ((localzhr.jdField_e_of_type_Int > paramInt2) && (paramInt2 > this.jdField_a_of_type_Int))
      {
        localzhr.jdField_e_of_type_Int = paramInt2;
        localzhr.jdField_d_of_type_Int = (paramInt2 - this.jdField_a_of_type_Int);
      }
      b(localzhr.jdField_d_of_type_Int, localzhr.jdField_e_of_type_Int);
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramzhr);
    a(paramzhr);
    yuq.a("0X80076D6");
  }
  
  public void c()
  {
    d();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = new EditVideoMusicDialog.MusicPlayTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    a(true);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = null;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    super.dismiss();
  }
  
  protected void e()
  {
    zhr localzhr = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if ((localzhr != null) && (localzhr.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Zho.a(localzhr) > 0) && (localzhr != null) && (!localzhr.equals(this.jdField_a_of_type_Zho.a())))
    {
      this.jdField_a_of_type_Zho.a(localzhr);
      this.jdField_a_of_type_Zho.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void onBackPressed()
  {
    f();
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
      f();
      yuq.a("0X80076DB");
      dismiss();
      continue;
      yuq.a("0X80076DC");
      g();
      continue;
      g();
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
        break label52;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onItemClick error musicInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label52:
      this.jdField_a_of_type_Zho.a(localzhr);
      this.jdField_a_of_type_Zho.notifyDataSetChanged();
      b();
      if (paramInt < this.jdField_a_of_type_Zho.a())
      {
        if (localzhr.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localzhr);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = "2";; localObject = "1")
          {
            yup.a("video_edit", "close_music", 0, 0, new String[] { localObject, "", "", "" });
            yuq.a("0X80076D3");
            break;
          }
        }
        if (localzhr.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localzhr);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = "2";; localObject = "1")
          {
            yup.a("video_edit", "clk_video_sound", 0, 0, new String[] { localObject, "", "", "" });
            yuq.a("0X80076D4");
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "2", true);
            break;
          }
        }
        if (localzhr.jdField_b_of_type_Int == 2) {
          if (!bhnv.g(BaseApplication.getContext()))
          {
            e();
            QQToast.a(BaseApplication.getContext(), 2131694659, 0).a();
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "click add qqmusic");
            }
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.c(false);
            d();
            localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
            int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
            if ((localObject instanceof BaseActivity)) {
              zhq.a((BaseActivity)localObject, i);
            }
            if (this.jdField_a_of_type_Boolean) {}
            for (localObject = "2";; localObject = "1")
            {
              yup.a("video_edit", "add_qqmusic", 0, 0, new String[] { localObject, "", "", "" });
              yuq.a("0X80076D5");
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
              break;
            }
          }
        }
      }
      else
      {
        if (localzhr.jdField_b_of_type_Int != 4) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(zhr.jdField_a_of_type_Zhr);
        if (this.jdField_a_of_type_Zhb != null) {
          this.jdField_a_of_type_Zhb.a(localzhr);
        }
      }
    }
    if (!TextUtils.isEmpty(localzhr.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localzhr.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localzhr);
    a(localzhr);
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      yup.a("video_edit", "add_music", 0, 0, new String[] { localObject, "", "", "" });
      yuq.a("0X80076D8", "", "", localzhr.jdField_b_of_type_JavaLangString, "");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog
 * JD-Core Version:    0.7.0.1
 */