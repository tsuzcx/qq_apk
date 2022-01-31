import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aomd
  implements aonc
{
  public aomd(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(aonh paramaonh)
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
    {
      this.a.a(paramaonh);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramaonh;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(aonh paramaonh, int paramInt)
  {
    if (!bbev.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      bcpw.a(this.a.app.getApplication(), 2131694609, 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      akbg localakbg;
      do
      {
        return false;
        localakbg = (akbg)this.a.app.a(57);
      } while (localakbg == null);
      this.a.jdField_a_of_type_Bcpq = new bcpq(this.a);
      this.a.jdField_a_of_type_Bcpq.a(ajyc.a(2131704286));
      this.a.jdField_a_of_type_Bcpq.setCancelable(false);
      this.a.jdField_a_of_type_Bcpq.show();
      try
      {
        long l1 = Long.valueOf(paramaonh.e).longValue();
        long l2 = Long.valueOf(paramaonh.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramaonh.d);
        }
        localakbg.a(l1, l2, paramaonh.d, paramInt);
        return true;
      }
      catch (Exception paramaonh) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop:" + paramaonh.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aomd
 * JD-Core Version:    0.7.0.1
 */