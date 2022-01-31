import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager.3;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class bjsx
  extends bjww
  implements aeid, bgpe
{
  private Intent b;
  
  private void D()
  {
    String str1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
    int i;
    int j;
    label33:
    String str2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 104)
    {
      i = 1;
      if (TextUtils.isEmpty(str1)) {
        break label128;
      }
      j = 1;
      if (j != 0)
      {
        j = b();
        str2 = a(str1);
        if (!a()) {
          break label133;
        }
      }
    }
    label128:
    label133:
    for (str1 = "2";; str1 = "1")
    {
      b("pub_changeface", j, 0, new String[] { "1", str2, str1 });
      if (i != 0) {
        vel.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      if (b()) {
        vel.a("video_edit", "pub_local", 0, 0, new String[0]);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label33;
    }
  }
  
  private void a(Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_Bjye.getActivity();
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    bfol localbfol = bfol.c(localActivity);
    localbfol.b(2131693383);
    localbfol.b(2131693393);
    localbfol.b(2131693381);
    localbfol.c(2131690596);
    localbfol.a(new bjta(this, localbfol, paramIntent, str, localActivity));
    localbfol.show();
  }
  
  private void a(Observer<bkkm> paramObserver)
  {
    bkkm localbkkm = new bkkm(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbkkm.b = bklf.a(2);
    localbkkm.jdField_a_of_type_Bkks = new bkks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    localbkkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localbkkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.actionType = 615;
    localbkkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.subactionType = 8;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bjwu)((Iterator)localObject).next()).a(0, localbkkm);
    }
    localObject = localbkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!TextUtils.isEmpty(localbkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
        break label336;
      }
    }
    label336:
    StringBuilder localStringBuilder;
    PublishVideoEntry localPublishVideoEntry;
    for (localbkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = ((String)localObject);; localPublishVideoEntry.videoDoodleDescription += (String)localObject)
    {
      localbkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(g()));
      localbkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()));
      vem.b("0X80076EA");
      veg.d("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
      this.jdField_a_of_type_Bjye.a(ajyc.a(2131703672), false, 500L);
      Stream.of(localbkkm).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new bkkp((bjsd)a(bjsd.class), null)).map(new bkld(bjsv.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new bklb()).map(new bklh(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
      localStringBuilder = new StringBuilder();
      localPublishVideoEntry = localbkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    }
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_Bjye != null)
    {
      Activity localActivity = this.jdField_a_of_type_Bjye.getActivity();
      if (localActivity != null) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new EditPicPartManager.3(this, localActivity), paramLong);
      }
    }
  }
  
  private static void b(bjsx parambjsx)
  {
    for (;;)
    {
      int i;
      try
      {
        parambjsx = ((bjsd)parambjsx.a(bjsd.class)).a();
        int j;
        if (!parambjsx.a().a())
        {
          parambjsx = parambjsx.a.a();
          j = parambjsx.jdField_a_of_type_Int;
          k = parambjsx.b;
          i = -1;
        }
        switch (j)
        {
        case 0: 
          axqw.b(null, "dc00898", "", "", "0X800A7C2", "0X800A7C2", i, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception parambjsx)
      {
        int k;
        veg.d("EditPicActivity.EditPicPartManager", "编辑涂鸦上报失败");
        return;
      }
      switch (k)
      {
      default: 
        break;
      case -1: 
        i = 2;
        break;
      case -2148308: 
        i = 3;
        break;
      case -1009097: 
        i = 4;
        break;
      case -8136876: 
        i = 5;
        break;
      case -13338378: 
        i = 6;
        continue;
        i = 1;
        continue;
        switch (k)
        {
        default: 
          break;
        case 1: 
          i = 7;
          break;
        case 2: 
          i = 8;
          break;
        case 3: 
          i = 9;
          break;
        case 4: 
          i = 10;
          break;
        case 5: 
          i = 11;
          continue;
          i = -1;
        }
        break;
      }
    }
  }
  
  private void d(int paramInt)
  {
    String str = acxv.a(ajsf.bj);
    Activity localActivity = this.jdField_a_of_type_Bjye.getActivity();
    localActivity.getIntent().putExtra("image_path", str);
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditPicPartManager", 2, "reset2Camera begin " + this.jdField_a_of_type_Bjye.getActivity() + " new path " + str);
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Bjye.a()).edit().putString("edit_pic_new_path", str).commit();
    Intent localIntent = new Intent();
    FileProvider7Helper.setSystemCapture(localActivity, new File(str), localIntent);
    localIntent.putExtra("android.intent.extra.quickCapture", true);
    try
    {
      localActivity.startActivityForResult(localIntent, 666);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      bcpw.a(localActivity, ajyc.a(2131703678), 0).a();
      localActivity.finish();
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("EditPicActivity.EditPicPartManager", 1, "reset2Camera err", localException1);
      }
    }
  }
  
  protected SimpleObserver<bkkm> a()
  {
    return new bjsy(this);
  }
  
  public void a()
  {
    D();
    a(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    if (paramInt1 == 18001) {
      if (paramInt2 == -1) {
        AIOLongShotHelper.a(this.jdField_a_of_type_Bjye.getActivity(), paramIntent);
      }
    }
    while ((paramInt1 != 18002) || (paramInt2 != -1))
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
      this.jdField_a_of_type_Bjye.a(-1, this.b, 2130772028, 0, false);
      this.b = null;
      return;
    }
    this.jdField_a_of_type_Bjye.a(-1, this.b, 2130772028, 0, false);
    this.b = null;
  }
  
  void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_Bjye.a(-1, null, 2130772028, 0, true);
      return;
    case 101: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1000);
      vel.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
      return;
    case 7: 
      if (QLog.isColorLevel())
      {
        Object localObject = paramIntent.getComponent();
        String str = ((ComponentName)localObject).getClassName();
        localObject = ((ComponentName)localObject).getPackageName();
        QLog.i("EditPicActivity.EditPicPartManager", 2, String.format(Locale.getDefault(), "gotoActivityForBusiness [%s, %s]", new Object[] { str, localObject }));
      }
      paramIntent.addFlags(603979776);
      paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 6: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1001);
      return;
    case 103: 
      paramIntent.addFlags(603979776);
      paramIntent.putExtra("sub_business_id", 103);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 8: 
      paramIntent.setClass(paramActivity, ReadInJoyDeliverUGCActivity.class);
      paramIntent.addFlags(603979776);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    }
    paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1050);
    paramActivity.startActivity(paramIntent);
    this.jdField_a_of_type_Bjye.a(-1, null, 2130772028, 0, true);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bjun(this, paramEditVideoParams.jdField_a_of_type_Long);
    this.jdField_a_of_type_Bjun = ((bjun)localObject);
    localArrayList.add(localObject);
    localObject = new bjtg(this);
    this.jdField_a_of_type_Bjtg = ((bjtg)localObject);
    localArrayList.add(localObject);
    localObject = new bjvc(this, paramEditVideoParams.jdField_a_of_type_Long);
    this.jdField_a_of_type_Bjvc = ((bjvc)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicRawImage(this, paramEditVideoParams.jdField_a_of_type_Long);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    localObject = new bjsw(this);
    this.jdField_a_of_type_Bjsw = ((bjsw)localObject);
    localArrayList.add(localObject);
    localObject = new bjxh(this);
    this.jdField_a_of_type_Bjxh = ((bjxh)localObject);
    localArrayList.add(localObject);
    localObject = new bjxj(this);
    this.jdField_a_of_type_Bjxj = ((bjxj)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 128))
    {
      localObject = new EditVideoArtFilter(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
      localArrayList.add(localObject);
    }
    if ((a(paramEditVideoParams.jdField_a_of_type_Long, 1)) && (a(paramEditVideoParams.jdField_a_of_type_Long, 274877906944L)) && (paramEditVideoParams.jdField_a_of_type_Int == 1) && (((DynamicTextConfigManager)bjae.a(7)).c()))
    {
      localObject = new bjuz(this, paramEditVideoParams.e);
      this.jdField_a_of_type_Bjuz = ((bjuz)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 8192))
    {
      localObject = new bjtb(this);
      this.jdField_a_of_type_Bjtb = ((bjtb)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 67108864))
    {
      localObject = new bjxw(this);
      this.jdField_a_of_type_Bjxw = ((bjxw)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 131072))
    {
      localObject = new bjxc(this);
      this.jdField_a_of_type_Bjxc = ((bjxc)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 8388608))
    {
      localObject = new bjxq(this);
      this.jdField_a_of_type_Bjxq = ((bjxq)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 268435456))
    {
      localObject = new bjyh(this);
      this.jdField_a_of_type_Bjyh = ((bjyh)localObject);
      localArrayList.add(localObject);
      localObject = new bkik(this);
      this.jdField_a_of_type_Bkik = ((bkik)localObject);
      localArrayList.add(localObject);
      localObject = new bjwi(this, this.jdField_a_of_type_Bjyh, this.jdField_a_of_type_Bkik);
      this.jdField_a_of_type_Bjwi = ((bjwi)localObject);
      localArrayList.add(localObject);
    }
    if ((paramEditVideoParams.jdField_a_of_type_Int == 1) && (a(paramEditVideoParams.jdField_a_of_type_Long, 131072))) {
      localArrayList.add(new bjtv(this));
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 33554432))
    {
      localObject = new bjwq(this);
      this.jdField_a_of_type_Bjwq = ((bjwq)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 34359738368L))
    {
      localObject = new bjwo(this);
      this.jdField_a_of_type_Bjwo = ((bjwo)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 1073741824))
    {
      localObject = new bjsj(this);
      this.jdField_a_of_type_Bjsj = ((bjsj)localObject);
      localArrayList.add(localObject);
    }
    int i;
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 16384))
    {
      if (paramEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) {
        break label747;
      }
      i = -1;
      if (i != -1) {
        break label762;
      }
      veg.e("EditPicActivity.EditPicPartManager", "pic curType have not set but it use BUSINESS_QQ ID, that is illegal!!");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = localArrayList;
      return;
      label747:
      i = paramEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
      break;
      label762:
      this.jdField_a_of_type_Bjrz = new bjrz(this, i, false);
      localArrayList.add(this.jdField_a_of_type_Bjrz);
    }
  }
  
  public void a(Error paramError)
  {
    veg.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Bjye.b();
    bcpw.a(this.jdField_a_of_type_Bjye.a(), ajyc.a(2131703675) + paramError, 0).a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(1000L);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Bjye.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    int k;
    if ((i == 103) && (i == 103))
    {
      i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
      j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
      k = ((Intent)localObject).getIntExtra("camera_capture_method", -1);
      if (i != 0) {
        break label326;
      }
      localObject = "0";
      if (j == -1) {
        break label333;
      }
      axqw.b(null, "dc00898", "", "", "0X8007376", "0X8007376", 0, 0, (String)localObject, "" + j, "", "");
      vem.b("0X80075E8");
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("cameraFrontBack", "" + i);
      ((HashMap)localObject).put("templateId", "" + j);
      ((HashMap)localObject).put("photoCaptureMethod", "" + k);
      axrl.a(BaseApplication.getContext()).a(null, "photo_send_from_shortvideo", true, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.e("EditPicActivity.EditPicPartManager", 2, "[ShortVideoMergeReport] tag=photo_send_from_shortvideo templateId=" + j + " camera=" + i);
      }
      ((bjbk)bjae.a(5)).a(this.jdField_a_of_type_Bjye.getActivity());
      return;
      label326:
      localObject = "1";
      break;
      label333:
      axqw.b(null, "dc00898", "", "", "0X8007375", "0X8007375", 0, 0, (String)localObject, "" + j, "", "");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(1000L);
    }
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_Bjye.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditPicPartManager", 2, "giveUpEditVideo, is from camera" + i + " clear photo " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      }
      new File(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()).delete();
      bbdr.a(this.jdField_a_of_type_Bjye.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      Intent localIntent = new Intent();
      localIntent.putExtra("p_e_r_c", true);
      localIntent.putExtra("camera_type", i);
      if (i == 103)
      {
        i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
        j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
        if (i == 0)
        {
          localObject = "0";
          if (j == -1) {
            break label324;
          }
          axqw.b(null, "dc00898", "", "", "0X80072C6", "0X80072C6", 0, 0, (String)localObject, "" + j, "", "");
          label241:
          this.jdField_a_of_type_Bjye.a(0, localIntent, 2130772028, 0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1)
      {
        i = g();
        vel.b("time_edit", 1, (int)(System.currentTimeMillis() - d()), new String[] { vel.b(i), "1", "", "" });
      }
      return;
      localObject = "1";
      break;
      label324:
      axqw.b(null, "dc00898", "", "", "0X80072C7", "0X80072C7", 0, 0, (String)localObject, "" + j, "", "");
      break label241;
      d(i);
      continue;
      this.jdField_a_of_type_Bjye.a(0, null, 2130772028, 0);
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Bjye.a(ajyc.a(2131703673), false, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsx
 * JD-Core Version:    0.7.0.1
 */