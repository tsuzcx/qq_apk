import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;

public class bkrg
  extends bkrk
  implements bksu
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private AECircleBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver = new AECircleBroadcastReceiver(this);
  private int jdField_b_of_type_Int = 3000;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 3000;
  private String jdField_c_of_type_JavaLangString;
  
  private bkrg(bkqs parambkqs)
  {
    super(parambkqs);
    bljn.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
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
      if (j <= this.jdField_c_of_type_Int)
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
  
  public static bkrb a(bkqs parambkqs)
  {
    if ((jdField_a_of_type_Bkrb == null) || (jdField_a_of_type_Bkrb.jdField_a_of_type_MqqUtilWeakReference.get() != parambkqs)) {}
    try
    {
      if ((jdField_a_of_type_Bkrb == null) || (jdField_a_of_type_Bkrb.jdField_a_of_type_MqqUtilWeakReference.get() != parambkqs)) {
        jdField_a_of_type_Bkrb = new bkrg(parambkqs);
      }
      return jdField_a_of_type_Bkrb;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (!((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label99;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755801);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559437);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label99:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void m()
  {
    if ((this.jdField_c_of_type_JavaLangString == null) && (Build.VERSION.SDK_INT >= 21))
    {
      if (!bdin.a())
      {
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689825), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      b(true);
      return;
    }
    blpw.a(this.jdField_a_of_type_Int, ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aiqy, this.jdField_c_of_type_JavaLangString, true);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    b(false);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("choosed_num", this.jdField_a_of_type_Aiqy.selectedPhotoList.size());
    paramView.putExtra("res_path", this.jdField_c_of_type_JavaLangString);
    LocalMediaInfo localLocalMediaInfo1 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int m = this.jdField_a_of_type_Aiqy.mediaPathsList.size();
    int k = 0;
    int j = 0;
    int i = paramInt;
    if (k < m)
    {
      String str = (String)this.jdField_a_of_type_Aiqy.mediaPathsList.get(k);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.jdField_a_of_type_Aiqy.allMediaInfoHashMap.get(str);
      if (bdfa.getMediaType(localLocalMediaInfo2) != 0) {
        break label281;
      }
      localArrayList1.add(str);
      if ((this.jdField_a_of_type_Aiqy.selectedPhotoList != null) && (this.jdField_a_of_type_Aiqy.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(j));
      }
      if (localLocalMediaInfo2.position.intValue() != paramInt) {
        break label278;
      }
      i = j;
      label200:
      j += 1;
    }
    label278:
    label281:
    for (;;)
    {
      k += 1;
      break;
      this.jdField_a_of_type_Aiqy.mediaPathsList = localArrayList1;
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aiqy.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (bdfa.getMediaType(localLocalMediaInfo1) == 0) {
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      return paramView;
      break label200;
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    azjs.a().a("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
    super.a(paramIntent);
    paramIntent = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.jdField_a_of_type_Aiqy.albumName = paramIntent;
      this.jdField_a_of_type_Aiqy.albumId = str;
    }
    this.jdField_b_of_type_Int = 3000;
    this.jdField_c_of_type_Int = 3000;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    bdfa.clearSelectItemInfo();
    bdfa.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_Aiqy.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_Aiqy.selectedPhotoList.size();; i = 0)
    {
      aips.b(paramView, i);
      if (this.jdField_a_of_type_Aiqz.i) {
        break;
      }
      if (this.jdField_a_of_type_Aiqy.a()) {
        xna.a().a(xna.a().c());
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bdfa.anim(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      return;
    }
    paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    }
    for (;;)
    {
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bdfa.anim(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.a(paramView, str1);
        bjdt.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), str3, paramView, 2);
      }
    }
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
    int i = bdfa.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689828), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          }
          return;
        }
        if (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() == 0) {
          if (i == 0) {
            this.jdField_a_of_type_Int = 0;
          }
        }
      }
    }
    for (;;)
    {
      super.a(paramView, paramInt, paramCheckBox);
      return;
      bljn.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (i == 0)
        {
          if (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo))
          {
            QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689826), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689823), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return;
          }
          if (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() >= 9) {
            QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689827), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          }
        }
      }
      else
      {
        bljn.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Int = 0;
        } else if (this.jdField_a_of_type_Int != 0) {
          bljn.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = azkt.c(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    if (this.jdField_b_of_type_Boolean) {
      m();
    }
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    return super.a(paramList);
  }
  
  public void b(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo;
    if (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() == 0)
    {
      localLocalMediaInfo = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
      switch (a(localLocalMediaInfo))
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Aiqy.selectedPhotoList.add(localLocalMediaInfo.path);
        this.jdField_a_of_type_Aiqy.selectedIndex.add(Integer.valueOf(paramInt));
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        paramView = (LinkedHashMap)bdfa.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
        if (paramView == null)
        {
          paramView = new LinkedHashMap();
          bdfa.sSelectItemPosMap.put(this.jdField_a_of_type_Aiqy.albumId, paramView);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = bdfa.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName);
        paramView.put(localLocalMediaInfo.path, localPair);
      }
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          bljn.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bkyt.a().a();
        }
        m();
        this.jdField_a_of_type_Aiqy.selectedPhotoList.clear();
        return;
        paramInt = 0;
        continue;
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131689831, 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689832), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689830), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689833), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), alud.a(2131689828), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
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
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setClickable(false);
    m();
  }
  
  protected void d()
  {
    super.d();
    String str = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131717497);
    int i = this.jdField_a_of_type_Aiqy.selectedPhotoList.size();
    if (i != 0) {
      str = str + "(" + i + ")";
    }
    for (;;)
    {
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrg
 * JD-Core Version:    0.7.0.1
 */