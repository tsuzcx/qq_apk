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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.MovieExporter;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tavcut.util.VideoUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class blmd
  extends blmr
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private bhhi jdField_a_of_type_Bhhi;
  private MovieExporter jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
  private int jdField_b_of_type_Int = 3000;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private boolean jdField_b_of_type_Boolean;
  private int c = 3000;
  
  public blmd(bllr parambllr)
  {
    super(parambllr);
    bmbx.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
  }
  
  private bhhi a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return null;
    }
    bhhi localbhhi = new bhhi(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localbhhi.a(AIOUtils.dp2px(50.0F, ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getResources()));
    localbhhi.a(true);
    localbhhi.c(false);
    localbhhi.g(-1);
    localbhhi.f(0);
    localbhhi.d(-15550475);
    localbhhi.i(3);
    localbhhi.jdField_f_of_type_Boolean = true;
    localbhhi.jdField_f_of_type_Int = 2;
    localbhhi.e(true);
    localbhhi.c(0);
    localbhhi.a(new blmh(this));
    return localbhhi;
  }
  
  private EncoderWriter.OutputConfig a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    bmmg localbmmg = bmme.a();
    paramLocalMediaInfo = localbmmg.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localbmmg.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    c(true);
    a(paramLocalMediaInfo, new blmf(this, System.currentTimeMillis(), paramLocalMediaInfo, paramInt));
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 1) {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 1)
        {
          if (paramInt1 == 0) {
            QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689749), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          }
          return true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) {
          if (paramInt1 == 0) {
            this.jdField_a_of_type_Int = 0;
          }
        }
      }
    }
    for (;;)
    {
      return false;
      bmbx.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (paramInt1 == 0)
        {
          if (((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramLocalMediaInfo))
          {
            QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689747), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return true;
          }
          if ((paramLocalMediaInfo.mediaWidth < 20) || (paramLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689743), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
          {
            paramLocalMediaInfo = BaseApplicationImpl.sApplication.getResources().getString(2131689748, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) });
            QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramLocalMediaInfo, 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return true;
          }
        }
      }
      else
      {
        bmbx.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Int = 0;
        } else if (this.jdField_a_of_type_Int != 0) {
          bmbx.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        }
      }
    }
  }
  
  private boolean a(String paramString, long paramLong)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      long l1 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(20));
      long l2 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(18));
      long l3 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(19));
      long l4 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
      long l5 = FileUtils.getFileSizes(paramString);
      bmbx.d("PhotoListLogicAECircle", "compress finish!\n outputPath: " + paramString + "\n outputDuring: " + l4 + "\n outputWidth: " + l2 + "\n outputHeight: " + l3 + "\n outputBitrate: " + l1 + "\n outputSize: " + l5 + " bytes");
      if ((l4 > 1000L + paramLong) || (l4 < paramLong - 1000L))
      {
        bmbx.d("PhotoListLogicAECircle", "[checkVideoIsOK] time error");
        return false;
      }
    }
    catch (NumberFormatException paramString)
    {
      bmbx.d("PhotoListLogicAECircle", "[checkVideoIsOK] NumberFormatException");
      return false;
    }
    catch (IllegalArgumentException paramString)
    {
      bmbx.d("PhotoListLogicAECircle", "[checkVideoIsOK] IllegalArgumentException");
      return false;
    }
    return true;
  }
  
  @NotNull
  private String b(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = bjma.a(paramLocalMediaInfo.path);
    String str = "";
    if (!StringUtil.isEmpty((String)localObject)) {
      paramLocalMediaInfo = (String)localObject + ".mp4";
    }
    for (;;)
    {
      return bmcz.b + File.separator + paramLocalMediaInfo;
      localObject = paramLocalMediaInfo.path.split("/");
      paramLocalMediaInfo = str;
      if (localObject.length > 0) {
        paramLocalMediaInfo = localObject[(localObject.length - 1)];
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      return;
    }
    LocalMediaInfo localLocalMediaInfo;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) && (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canPickVideo))
    {
      localLocalMediaInfo = ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bllm.a(paramInt);
      int i = a(localLocalMediaInfo);
      switch (i)
      {
      case 1: 
      default: 
        d(i);
        return;
      case 0: 
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (localObject == null)
        {
          localObject = new LinkedHashMap();
          AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, localObject);
        }
        break;
      }
    }
    for (;;)
    {
      ((LinkedHashMap)localObject).put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      localObject = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject).containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        ((HashMap)localObject).put(localLocalMediaInfo.path, localPair);
      }
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          bmbx.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bltp.a().a();
        }
        k();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
        return;
        paramInt = 0;
        continue;
        try
        {
          a(paramInt, localLocalMediaInfo);
          return;
        }
        catch (Exception localException)
        {
          bmbx.d("PhotoListLogicAECircle", localException.toString());
          c(false);
          QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689752), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          return;
        }
        QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689749), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        paramInt = 1;
      }
    }
  }
  
  private void c(int paramInt)
  {
    int i = a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bllm.a(paramInt));
    switch (i)
    {
    case 1: 
    default: 
      d(i);
      return;
    }
    a(paramInt, (bllo)((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(paramInt));
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() != null) && (!((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label180;
      }
      if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_Bhhi == null))
      {
        this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755826);
        this.jdField_b_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_b_of_type_AndroidAppDialog.setContentView(2131558568);
        localImageView = (ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131369206);
        localButton = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131363773);
        this.jdField_a_of_type_Bhhi = a();
        localImageView.setImageDrawable(this.jdField_a_of_type_Bhhi);
        localButton.setOnClickListener(new blmg(this));
      }
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
    label180:
    while ((this.jdField_b_of_type_AndroidAppDialog == null) || (!this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      ImageView localImageView;
      Button localButton;
      return;
    }
    this.jdField_b_of_type_AndroidAppDialog.dismiss();
    this.jdField_a_of_type_Bhhi = null;
    this.jdField_b_of_type_AndroidAppDialog = null;
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      return;
    case 3: 
      QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689753), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      return;
    case 4: 
      QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689751), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      return;
    }
    QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), amtj.a(2131689754), 0).b(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (!((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label101;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755826);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559574);
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
    bmnm.a(this.jdField_a_of_type_Int, ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, true);
    d(false);
  }
  
  protected int a(LocalMediaInfo paramLocalMediaInfo)
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
      if (j <= this.c)
      {
        j = this.jdField_b_of_type_Int;
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
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str;
    }
    this.jdField_b_of_type_Int = 3000;
    this.c = 3000;
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.clearCache();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();; i = 0)
    {
      ajpv.b(paramView, i);
      if (this.jdField_a_of_type_Ajqu.i) {
        break;
      }
      ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      bmbc.a().b(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
    }
    paramView = ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    }
    for (;;)
    {
      ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      break;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramView, str1);
        QZoneHelper.launchQZone(((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), str3, paramView, 2);
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      c(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bllm.a(paramInt);
    int i = AlbumUtil.getMediaType(localLocalMediaInfo);
    int j = localLocalMediaInfo.selectStatus;
    if ((!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && (a(localLocalMediaInfo, i, j))) {
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    if (this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter != null) {
      this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.cancelCompress();
    }
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter = new MovieExporter();
    String str = b(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = a(paramLocalMediaInfo);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.compressVideo(paramLocalMediaInfo.path, str, localOutputConfig, new blme(this, paramVideoCompressListener, str));
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    boolean bool = super.a(paramList);
    long l2;
    long l1;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      paramList = (bllr)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (blvr.j(paramList))
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
    bmbc.a().a(l1, l2);
    return bool;
  }
  
  protected boolean b()
  {
    return this.jdField_b_of_type_AndroidAppDialog != null;
  }
  
  public void c(View paramView)
  {
    k();
  }
  
  protected void e()
  {
    super.e();
    String str = ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131716088);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    int j = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum + i;
    if (j != 0) {
      str = str + "(" + j + ")";
    }
    for (;;)
    {
      ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setText(str);
      if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {}
      for (i = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForMix; j < i; i = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForNormal)
      {
        ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setEnabled(false);
        return;
      }
      ((bllr)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setEnabled(true);
      return;
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter != null) {
      this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.cancelCompress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmd
 * JD-Core Version:    0.7.0.1
 */