import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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

public class bnfz
  extends bngh
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private biaj jdField_a_of_type_Biaj;
  private MovieExporter jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
  private Dialog b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private int d = 3000;
  private int e = 3000;
  
  public bnfz(bnfn parambnfn)
  {
    super(parambnfn);
    bnzb.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
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
      if (j <= this.e)
      {
        j = this.d;
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
  
  private biaj a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return null;
    }
    biaj localbiaj = new biaj(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localbiaj.a(afur.a(50.0F, ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getResources()));
    localbiaj.a(true);
    localbiaj.c(false);
    localbiaj.f(-1);
    localbiaj.e(0);
    localbiaj.d(-15550475);
    localbiaj.g(3);
    localbiaj.jdField_f_of_type_Boolean = true;
    localbiaj.jdField_f_of_type_Int = 2;
    localbiaj.e(true);
    localbiaj.c(0);
    localbiaj.a(new bngc(this));
    return localbiaj;
  }
  
  private EncoderWriter.OutputConfig a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    bohp localbohp = bohn.a();
    paramLocalMediaInfo = localbohp.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localbohp.b();
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
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.compressVideo(paramLocalMediaInfo.path, str, localOutputConfig, new bnga(this, l, localOutputConfig, paramLocalMediaInfo, paramInt, str));
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
      long l5 = bgmg.a(paramString);
      bnzb.d("PhotoListLogicAECircle", "compress finish!\n outputPath: " + paramString + "\n outputDuring: " + l4 + "\n outputWidth: " + l2 + "\n outputHeight: " + l3 + "\n outputBitrate: " + l1 + "\n outputSize: " + l5 + " bytes");
      if ((l4 > 1000L + paramLong) || (l4 < paramLong - 1000L))
      {
        bnzb.d("PhotoListLogicAECircle", "[checkVideoIsOK] time error");
        return false;
      }
    }
    catch (NumberFormatException paramOutputConfig)
    {
      bnzb.d("PhotoListLogicAECircle", "[checkVideoIsOK] NumberFormatException");
      return false;
    }
    catch (IllegalArgumentException paramOutputConfig)
    {
      bnzb.d("PhotoListLogicAECircle", "[checkVideoIsOK] IllegalArgumentException");
      return false;
    }
    return true;
  }
  
  @NotNull
  private String b(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = bkfg.a(paramLocalMediaInfo.path);
    String str = "";
    if (!bgsp.a((String)localObject)) {
      paramLocalMediaInfo = (String)localObject + ".mp4";
    }
    for (;;)
    {
      return bnzu.b + File.separator + paramLocalMediaInfo;
      localObject = paramLocalMediaInfo.path.split("/");
      paramLocalMediaInfo = str;
      if (localObject.length > 0) {
        paramLocalMediaInfo = localObject[(localObject.length - 1)];
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() != null) && (!((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label180;
      }
      if ((this.b == null) || (this.jdField_a_of_type_Biaj == null))
      {
        this.b = new ReportDialog(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755823);
        this.b.setCancelable(false);
        this.b.setCanceledOnTouchOutside(false);
        this.b.setContentView(2131558564);
        localImageView = (ImageView)this.b.findViewById(2131369093);
        localButton = (Button)this.b.findViewById(2131363718);
        this.jdField_a_of_type_Biaj = a();
        localImageView.setImageDrawable(this.jdField_a_of_type_Biaj);
        localButton.setOnClickListener(new bngb(this));
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
    this.jdField_a_of_type_Biaj = null;
    this.b = null;
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (!((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label101;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755823);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559567);
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
    boiv.a(this.jdField_c_of_type_Int, ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, true);
    c(false);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    if (this.b != null) {
      return null;
    }
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("choosed_num", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
    LocalMediaInfo localLocalMediaInfo1 = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bnfi.a(paramInt);
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
      if (bgkc.getMediaType(localLocalMediaInfo2) != 0) {
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
      if (bgkc.getMediaType(localLocalMediaInfo1) == 0) {
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      return paramView;
      break label199;
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str;
    }
    this.d = 3000;
    this.e = 3000;
  }
  
  public void a(View paramView)
  {
    bgkc.clearSelectItemInfo();
    bgkc.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();; i = 0)
    {
      akgm.b(paramView, i);
      if (this.jdField_a_of_type_Akht.i) {
        break;
      }
      ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bgkc.anim(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      bnyh.a().a(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
    }
    paramView = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    }
    for (;;)
    {
      ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bgkc.anim(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      break;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.a(paramView, str1);
        blsb.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), str3, paramView, 2);
      }
    }
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bnfi.a(paramInt);
    int i = bgkc.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.jdField_c_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689733), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          }
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) {
          if (i == 0) {
            this.jdField_c_of_type_Int = 0;
          }
        }
      }
    }
    for (;;)
    {
      super.a(paramView, paramInt, paramCheckBox);
      return;
      bnzb.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_c_of_type_Int == 0)
      {
        if (i == 0)
        {
          if (((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo))
          {
            QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689731), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689728), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= 9) {
            QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689732), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          }
        }
      }
      else
      {
        bnzb.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_c_of_type_Int == 1) {
          this.jdField_c_of_type_Int = 0;
        } else if (this.jdField_c_of_type_Int != 0) {
          bnzb.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        }
      }
    }
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    boolean bool = super.a(paramList);
    long l2;
    long l1;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      paramList = (bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (bnqb.j(paramList))
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
    bnyh.a().a(l1, l2);
    return bool;
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.b != null) {
      return;
    }
    LocalMediaInfo localLocalMediaInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0)
    {
      localLocalMediaInfo = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bnfi.a(paramInt);
      switch (a(localLocalMediaInfo))
      {
      default: 
        return;
      case 0: 
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        paramView = (LinkedHashMap)bgkc.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (paramView == null)
        {
          paramView = new LinkedHashMap();
          bgkc.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramView);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = bgkc.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramView.put(localLocalMediaInfo.path, localPair);
      }
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          bnzb.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bnnx.a().a();
        }
        k();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
        return;
        paramInt = 0;
        continue;
        QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        try
        {
          a(paramInt, localLocalMediaInfo);
          return;
        }
        catch (Exception paramView)
        {
          bnzb.d("PhotoListLogicAECircle", paramView.toString());
          b(false);
          QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689736), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          return;
        }
        QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689737), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689735), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689738), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), anni.a(2131689733), 0).b(((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        paramInt = 1;
      }
    }
  }
  
  protected boolean b()
  {
    return this.b != null;
  }
  
  public void c()
  {
    super.c();
  }
  
  public void c(View paramView)
  {
    k();
  }
  
  protected void d()
  {
    super.d();
    String str = ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131715745);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    if (i != 0) {
      str = str + "(" + i + ")";
    }
    for (;;)
    {
      ((bnfn)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfz
 * JD-Core Version:    0.7.0.1
 */