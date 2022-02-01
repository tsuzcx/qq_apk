import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.MovieExporter;
import com.tencent.tavcut.util.VideoUtil;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class bohh
  extends bohp
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private bjbh jdField_a_of_type_Bjbh;
  private MovieExporter jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
  private Dialog b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private int e = 3000;
  private int f;
  
  public bohh(bogv parambogv)
  {
    super(parambogv);
    this.jdField_f_of_type_Int = 3000;
    bpam.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
  }
  
  private int a(LocalMediaInfo paramLocalMediaInfo)
  {
    long l = paramLocalMediaInfo.mDuration;
    if ((l > 3600000L) || (l < 2000L)) {
      return 1;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
      int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      paramLocalMediaInfo = localMediaMetadataRetriever.extractMetadata(12);
      if (j <= this.jdField_f_of_type_Int)
      {
        j = this.e;
        if (i <= j) {}
      }
      else
      {
        return 2;
      }
      if (!paramLocalMediaInfo.equals(jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        boolean bool = paramLocalMediaInfo.equals(jdField_a_of_type_ArrayOfJavaLangString[1]);
        if (!bool) {
          return 3;
        }
      }
      return 0;
    }
    catch (Exception paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        paramLocalMediaInfo.printStackTrace();
      }
      return 5;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  private bjbh a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return null;
    }
    bjbh localbjbh = new bjbh(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localbjbh.a(agej.a(50.0F, ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getResources()));
    localbjbh.a(true);
    localbjbh.c(false);
    localbjbh.g(-1);
    localbjbh.f(0);
    localbjbh.d(-15550475);
    localbjbh.i(3);
    localbjbh.jdField_f_of_type_Boolean = true;
    localbjbh.jdField_f_of_type_Int = 2;
    localbjbh.e(true);
    localbjbh.c(0);
    localbjbh.a(new bohk(this));
    return localbjbh;
  }
  
  private EncoderWriter.OutputConfig a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    bpjk localbpjk = bpji.a();
    paramLocalMediaInfo = localbpjk.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localbpjk.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    b(true);
    if (this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter != null) {
      this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.cancelCompress();
    }
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter = new MovieExporter();
    String str = b(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = a(paramLocalMediaInfo);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.compressVideo(paramLocalMediaInfo.path, str, localOutputConfig, new bohi(this, l, localOutputConfig, paramLocalMediaInfo, paramInt, str));
  }
  
  private boolean a(EncoderWriter.OutputConfig paramOutputConfig, String paramString, long paramLong)
  {
    try
    {
      paramOutputConfig = new MediaMetadataRetriever();
      paramOutputConfig.setDataSource(paramString);
      long l1 = Long.parseLong(paramOutputConfig.extractMetadata(20));
      long l2 = Long.parseLong(paramOutputConfig.extractMetadata(18));
      long l3 = Long.parseLong(paramOutputConfig.extractMetadata(19));
      long l4 = Long.parseLong(paramOutputConfig.extractMetadata(9));
      long l5 = bhmi.a(paramString);
      bpam.d("PhotoListLogicAECircle", "compress finish!\n outputPath: " + paramString + "\n outputDuring: " + l4 + "\n outputWidth: " + l2 + "\n outputHeight: " + l3 + "\n outputBitrate: " + l1 + "\n outputSize: " + l5 + " bytes");
      if ((l4 > 1000L + paramLong) || (l4 < paramLong - 1000L))
      {
        bpam.d("PhotoListLogicAECircle", "[checkVideoIsOK] time error");
        return false;
      }
    }
    catch (NumberFormatException paramOutputConfig)
    {
      bpam.d("PhotoListLogicAECircle", "[checkVideoIsOK] NumberFormatException");
      return false;
    }
    catch (IllegalArgumentException paramOutputConfig)
    {
      bpam.d("PhotoListLogicAECircle", "[checkVideoIsOK] IllegalArgumentException");
      return false;
    }
    return true;
  }
  
  @NotNull
  private String b(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = blgk.a(paramLocalMediaInfo.path);
    String str = "";
    if (!bhsr.a((String)localObject)) {
      paramLocalMediaInfo = (String)localObject + ".mp4";
    }
    for (;;)
    {
      return bpbp.b + File.separator + paramLocalMediaInfo;
      localObject = paramLocalMediaInfo.path.split("/");
      paramLocalMediaInfo = str;
      if (localObject.length > 0) {
        paramLocalMediaInfo = localObject[(localObject.length - 1)];
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() != null) && (!((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label180;
      }
      if ((this.b == null) || (this.jdField_a_of_type_Bjbh == null))
      {
        this.b = new ReportDialog(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755824);
        this.b.setCancelable(false);
        this.b.setCanceledOnTouchOutside(false);
        this.b.setContentView(2131558566);
        localImageView = (ImageView)this.b.findViewById(2131369183);
        localButton = (Button)this.b.findViewById(2131363744);
        this.jdField_a_of_type_Bjbh = a();
        localImageView.setImageDrawable(this.jdField_a_of_type_Bjbh);
        localButton.setOnClickListener(new bohj(this));
      }
      this.b.show();
    }
    label180:
    while ((this.b == null) || (!this.b.isShowing()))
    {
      ImageView localImageView;
      Button localButton;
      return;
    }
    this.b.dismiss();
    this.jdField_a_of_type_Bjbh = null;
    this.b = null;
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (!((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label101;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755824);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559572);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label101:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void k()
  {
    bpkq.a(this.jdField_d_of_type_Int, ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, true);
    c(false);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Intent a(View paramView, int paramInt)
  {
    if (this.b != null) {
      return null;
    }
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("choosed_num", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
    LocalMediaInfo localLocalMediaInfo1 = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.size();
    int k = 0;
    int j = 0;
    int i = paramInt;
    if (k < m)
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.get(k);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str);
      if (bhkd.getMediaType(localLocalMediaInfo2) != 0) {
        break label280;
      }
      localArrayList1.add(str);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(j));
      }
      if (localLocalMediaInfo2.position.intValue() != paramInt) {
        break label277;
      }
      i = j;
      label199:
      j += 1;
    }
    label277:
    label280:
    for (;;)
    {
      k += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList = localArrayList1;
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (bhkd.getMediaType(localLocalMediaInfo1) == 0) {
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      return paramView;
      break label199;
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str;
    }
    this.jdField_c_of_type_Int = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.jdField_c_of_type_Boolean = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", false);
    bpam.a("PhotoListLogicAECircle", "[AdditionalPick] initData---initialHasPickedNum=" + this.jdField_c_of_type_Int + ", canPickVideo=" + this.jdField_c_of_type_Boolean);
    this.e = 3000;
    this.jdField_f_of_type_Int = 3000;
  }
  
  public void a(View paramView)
  {
    bhkd.clearSelectItemInfo();
    bhkd.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();; i = 0)
    {
      akrx.b(paramView, i);
      if (this.jdField_a_of_type_Akte.i) {
        break;
      }
      ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bhkd.anim(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      bozr.a().a(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
    }
    paramView = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    }
    for (;;)
    {
      ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bhkd.anim(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      break;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.a(paramView, str1);
        bmtd.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), str3, paramView, 2);
      }
    }
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
    int i = bhkd.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.jdField_d_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689738), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
          }
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) {
          if (i == 0) {
            this.jdField_d_of_type_Int = 0;
          }
        }
      }
    }
    for (;;)
    {
      super.a(paramView, paramInt, paramCheckBox);
      return;
      bpam.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        if (i == 0)
        {
          if (((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo))
          {
            QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689736), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689733), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_c_of_type_Int >= 9)
          {
            paramView = BaseApplicationImpl.sApplication.getResources().getString(2131689737, new Object[] { Integer.valueOf(9) });
            QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramView, 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
          }
        }
      }
      else
      {
        bpam.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_d_of_type_Int == 1) {
          this.jdField_d_of_type_Int = 0;
        } else if (this.jdField_d_of_type_Int != 0) {
          bpam.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    boolean bool = super.a(paramList);
    long l2;
    long l1;
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      paramList = (bogv)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (born.j(paramList))
        {
          l2 = System.currentTimeMillis();
          l1 = l2 - paramList.getLongExtra("PhotoConst.timestamp", 0L);
          l2 -= paramList.getLongExtra("PhotoConst.timestamp_last_activity", 0L);
          if ((l1 <= 60000L) && (l2 <= 60000L) && (l1 >= 0L) && (l2 >= 0L)) {
            break label117;
          }
        }
      }
    }
    return bool;
    label117:
    bozr.a().a(l1, l2);
    return bool;
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.b != null) {
      return;
    }
    LocalMediaInfo localLocalMediaInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) && (a()))
    {
      localLocalMediaInfo = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bogq.a(paramInt);
      switch (a(localLocalMediaInfo))
      {
      default: 
        return;
      case 0: 
        this.jdField_d_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        paramView = (LinkedHashMap)bhkd.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (paramView == null)
        {
          paramView = new LinkedHashMap();
          bhkd.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramView);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = bhkd.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramView.put(localLocalMediaInfo.path, localPair);
      }
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          bpam.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bopi.a().a();
        }
        k();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
        return;
        paramInt = 0;
        continue;
        QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        return;
        try
        {
          a(paramInt, localLocalMediaInfo);
          return;
        }
        catch (Exception paramView)
        {
          bpam.d("PhotoListLogicAECircle", paramView.toString());
          b(false);
          QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689741), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
          return;
        }
        QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689742), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        return;
        QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689740), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        return;
        QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689743), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        return;
        QQToast.a(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anzj.a(2131689738), 0).b(((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        return;
        paramInt = 1;
      }
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void c(View paramView)
  {
    k();
  }
  
  protected boolean c()
  {
    return this.b != null;
  }
  
  protected void d()
  {
    super.d();
    String str = ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131715854);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_c_of_type_Int;
    if (i != 0) {
      str = str + "(" + i + ")";
    }
    for (;;)
    {
      ((bogv)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohh
 * JD-Core Version:    0.7.0.1
 */