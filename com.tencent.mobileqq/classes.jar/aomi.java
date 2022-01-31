import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aomi
  implements aonh
{
  public aomi(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(aonm paramaonm)
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
    {
      this.a.a(paramaonm);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramaonm;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(aonm paramaonm, int paramInt)
  {
    if (!bbfj.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      bcql.a(this.a.app.getApplication(), 2131694610, 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      akbf localakbf;
      do
      {
        return false;
        localakbf = (akbf)this.a.app.a(57);
      } while (localakbf == null);
      this.a.jdField_a_of_type_Bcqf = new bcqf(this.a);
      this.a.jdField_a_of_type_Bcqf.a(ajya.a(2131704297));
      this.a.jdField_a_of_type_Bcqf.setCancelable(false);
      this.a.jdField_a_of_type_Bcqf.show();
      try
      {
        long l1 = Long.valueOf(paramaonm.e).longValue();
        long l2 = Long.valueOf(paramaonm.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramaonm.d);
        }
        localakbf.a(l1, l2, paramaonm.d, paramInt);
        return true;
      }
      catch (Exception paramaonm) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop:" + paramaonm.toString());
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
 * Qualified Name:     aomi
 * JD-Core Version:    0.7.0.1
 */