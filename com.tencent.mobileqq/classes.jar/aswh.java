import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aswh
  implements asxg
{
  public aswh(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(asxl paramasxl)
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
    {
      this.a.a(paramasxl);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramasxl;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(asxl paramasxl, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.a.app.getApplication(), 2131694255, 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      anzl localanzl;
      do
      {
        return false;
        localanzl = (anzl)this.a.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
      } while (localanzl == null);
      this.a.jdField_a_of_type_Bisl = new bisl(this.a);
      this.a.jdField_a_of_type_Bisl.a(anvx.a(2131703766));
      this.a.jdField_a_of_type_Bisl.setCancelable(false);
      this.a.jdField_a_of_type_Bisl.show();
      try
      {
        long l1 = Long.valueOf(paramasxl.e).longValue();
        long l2 = Long.valueOf(paramasxl.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramasxl.d);
        }
        localanzl.a(l1, l2, paramasxl.d, paramInt);
        return true;
      }
      catch (Exception paramasxl) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop:" + paramasxl.toString());
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.a.jdField_b_of_type_Int == 1) {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a);
    }
  }
  
  public void d()
  {
    this.a.g();
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "afterDetailViewHide 详情页返回");
    }
    this.a.g = "";
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(13, this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswh
 * JD-Core Version:    0.7.0.1
 */