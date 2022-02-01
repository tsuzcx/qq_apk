import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class atft
  implements atgs
{
  public atft(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(atgx paramatgx)
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
    {
      this.a.a(paramatgx);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramatgx;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(atgx paramatgx, int paramInt)
  {
    if (!bhnv.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.a.app.getApplication(), 2131693965, 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      aocv localaocv;
      do
      {
        return false;
        localaocv = (aocv)this.a.app.a(57);
      } while (localaocv == null);
      this.a.jdField_a_of_type_Bjbs = new bjbs(this.a);
      this.a.jdField_a_of_type_Bjbs.a(anzj.a(2131703185));
      this.a.jdField_a_of_type_Bjbs.setCancelable(false);
      this.a.jdField_a_of_type_Bjbs.show();
      try
      {
        long l1 = Long.valueOf(paramatgx.e).longValue();
        long l2 = Long.valueOf(paramatgx.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramatgx.d);
        }
        localaocv.a(l1, l2, paramatgx.d, paramInt);
        return true;
      }
      catch (Exception paramatgx) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop:" + paramatgx.toString());
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
 * Qualified Name:     atft
 * JD-Core Version:    0.7.0.1
 */