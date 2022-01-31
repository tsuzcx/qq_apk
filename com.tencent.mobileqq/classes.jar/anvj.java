import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class anvj
  implements anwi
{
  public anvj(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(anwn paramanwn)
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
    {
      this.a.a(paramanwn);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramanwn;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(anwn paramanwn, int paramInt)
  {
    if (!badq.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      bbmy.a(this.a.app.getApplication(), 2131628948, 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      ajmx localajmx;
      do
      {
        return false;
        localajmx = (ajmx)this.a.app.a(57);
      } while (localajmx == null);
      this.a.jdField_a_of_type_Bbms = new bbms(this.a);
      this.a.jdField_a_of_type_Bbms.a(ajjy.a(2131638501));
      this.a.jdField_a_of_type_Bbms.setCancelable(false);
      this.a.jdField_a_of_type_Bbms.show();
      try
      {
        long l1 = Long.valueOf(paramanwn.e).longValue();
        long l2 = Long.valueOf(paramanwn.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramanwn.d);
        }
        localajmx.a(l1, l2, paramanwn.d, paramInt);
        return true;
      }
      catch (Exception paramanwn) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop:" + paramanwn.toString());
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
 * Qualified Name:     anvj
 * JD-Core Version:    0.7.0.1
 */