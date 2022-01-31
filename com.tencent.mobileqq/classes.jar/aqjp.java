import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aqjp
  implements aqko
{
  public aqjp(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(aqkt paramaqkt)
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == this.a.d.size())
    {
      this.a.a(paramaqkt);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramaqkt;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(aqkt paramaqkt, int paramInt)
  {
    if (!bdin.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.a.app.getApplication(), 2131694768, 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      alxj localalxj;
      do
      {
        return false;
        localalxj = (alxj)this.a.app.a(57);
      } while (localalxj == null);
      this.a.jdField_a_of_type_Bety = new bety(this.a);
      this.a.jdField_a_of_type_Bety.a(alud.a(2131704681));
      this.a.jdField_a_of_type_Bety.setCancelable(false);
      this.a.jdField_a_of_type_Bety.show();
      try
      {
        long l1 = Long.valueOf(paramaqkt.e).longValue();
        long l2 = Long.valueOf(paramaqkt.jdField_b_of_type_JavaLangString).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramaqkt.d);
        }
        localalxj.a(l1, l2, paramaqkt.d, paramInt);
        return true;
      }
      catch (Exception paramaqkt) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "joinTroop:" + paramaqkt.toString());
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
 * Qualified Name:     aqjp
 * JD-Core Version:    0.7.0.1
 */