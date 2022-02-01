import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

public class bohb
  extends boha<bogu>
  implements bogz
{
  protected akst a;
  protected final boolean a;
  
  protected bohb(bogu parambogu)
  {
    super(parambogu);
    this.jdField_a_of_type_Boolean = bpan.a();
    this.jdField_a_of_type_Bogz = this;
    this.a = new akst();
    this.jdField_a_of_type_Akst = ((akst)this.a);
  }
  
  public static bogy a(bogu parambogu)
  {
    if ((jdField_a_of_type_Bogy == null) || (jdField_a_of_type_Bogy.jdField_a_of_type_MqqUtilWeakReference.get() != parambogu)) {}
    try
    {
      if ((jdField_a_of_type_Bogy == null) || (jdField_a_of_type_Bogy.jdField_a_of_type_MqqUtilWeakReference.get() != parambogu)) {
        jdField_a_of_type_Bogy = new bohb(parambogu);
      }
      return jdField_a_of_type_Bogy;
    }
    finally {}
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    paramViewGroup = a();
    Object localObject = paramViewGroup.a(paramInt);
    TextView localTextView = (TextView)paramView;
    if (((QQAlbumInfo)localObject)._id.equals("qzone_album"))
    {
      localObject = paramViewGroup.jdField_a_of_type_AndroidContentResResources.getDrawable(2130847668);
      ((Drawable)localObject).setBounds(0, 0, paramViewGroup.jdField_a_of_type_Int, paramViewGroup.jdField_b_of_type_Int);
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    paramView.setBackgroundResource(2131165215);
    localTextView.setTextColor(paramViewGroup.jdField_a_of_type_AndroidContentResResources.getColor(2131165343));
    return paramView;
  }
  
  protected bogf a()
  {
    return new bogg((bogu)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
  
  protected bogg a()
  {
    return (bogg)super.b();
  }
  
  public String a()
  {
    return super.a();
  }
  
  public List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return super.a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    paramList1 = super.a(paramList1, paramList2, paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty()) && (paramInt == -1) && (a().jdField_b_of_type_Boolean) && (a().jdField_a_of_type_Long > 0L))
    {
      paramList2 = new QQAlbumInfo();
      paramList2._id = "qzone_album";
      paramList2.name = "空间相册";
      paramList2.mMediaFileCount = ((int)a().jdField_a_of_type_Long);
      paramList1.add(0, paramList2);
    }
    return paramList1;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Akst.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    String str2 = paramIntent.getStringExtra("peak.myUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = bplg.a().getCurrentAccountUin();
    }
    if (str1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin = str1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin == null) {
      throw new RuntimeException("must set MY_UIN");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mIsDisableTroopAlbum = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mIsDisableTroopAlbum);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum)
    {
      paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), bcvl.class);
      paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this.jdField_a_of_type_Akst.jdField_a_of_type_Ayxo);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
    }
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    Object localObject;
    if (paramQQAlbumInfo._id.equals("qzone_album"))
    {
      localObject = paramIntent.getExtras();
      ((Bundle)localObject).putInt("key_personal_album_enter_model", 1);
      ((Bundle)localObject).putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      ((Bundle)localObject).putSerializable("PhotoConst.PHOTO_INFOS", paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      ((Bundle)localObject).putStringArrayList("PhotoConst.PHOTO_PATHS", paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      bmtk localbmtk = bmtk.a();
      localbmtk.a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ((Bundle)localObject).putString("keyAction", "actionSelectPicture");
      ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
      bmtd.a(((bogu)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), localbmtk, (Bundle)localObject, 100016);
      return a(paramIntent, paramQQAlbumInfo);
    }
    if (paramQQAlbumInfo._id.equals("$CustomAlbumId"))
    {
      localObject = zkg.a().b();
      if (((List)localObject).size() > 0) {
        paramIntent.putExtra("ALBUM_NAME", ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName);
      }
      paramIntent.putExtra("ALBUM_ID", "$CustomAlbumId");
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
      paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
      paramIntent.putExtra("report_first_exposure", true);
      paramIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", false);
      return a(paramIntent, paramQQAlbumInfo);
    }
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    if ("$VideoAlbumId".equals(paramQQAlbumInfo._id)) {
      bdll.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
    }
    return super.a(paramQQAlbumInfo, paramInt, paramIntent);
  }
  
  boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return (!paramQQAlbumInfo._id.equals("qzone_album")) && (paramBoolean);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohb
 * JD-Core Version:    0.7.0.1
 */