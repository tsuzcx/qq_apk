import android.os.Message;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aomq
  extends ajzk
{
  public aomq(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void a(aonr paramaonr, boolean paramBoolean, int paramInt)
  {
    super.a(paramaonr, paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, pushTime=" + paramInt + "from_type=" + this.a.jdField_b_of_type_Int);
    }
    if (paramaonr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=null!!");
      }
      if ((this.a.jdField_b_of_type_Int == 0) && (paramaonr != null) && (!this.a.a(paramaonr, this.a.jdField_a_of_type_JavaUtilList)))
      {
        this.a.jdField_a_of_type_JavaUtilList.add(paramaonr);
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, mhasShowList=" + this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "mNeedShowList.size()" + this.a.d.size());
        }
        if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != this.a.d.size()) {
          break label267;
        }
        Face2FaceAddFriendActivity.a(this.a, paramaonr);
      }
    }
    for (;;)
    {
      paramaonr = this.a;
      paramaonr.j += 1;
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=" + paramaonr.e);
      break;
      label267:
      Message localMessage = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      localMessage.what = 10;
      localMessage.obj = paramaonr;
      Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(10, this.a.a());
    }
  }
  
  protected void a(boolean paramBoolean, List<aonr> paramList, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramList, paramInt1, paramInt2);
    if (paramBoolean)
    {
      this.a.e = 1;
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList heartBeatTime=" + paramInt2 + "from_type=" + this.a.jdField_b_of_type_Int + "reqInterval=" + paramInt1 + "好友列表返回isSuccess=" + paramBoolean);
      }
      if (paramList == null) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList size=" + paramList.size());
      }
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 2;
      }
      long l = System.currentTimeMillis() - aone.c;
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList interval=" + l + "leaveFaceTofaceTime=" + aone.c);
      }
      if ((l > i * 1000) || (aone.c == 0L)) {
        break label259;
      }
      Face2FaceAddFriendActivity.a(this.a, i * 1000 - l);
      return;
      this.a.e = 2;
      break;
      label241:
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList is null");
      }
    }
    label259:
    if (paramInt2 > 0) {
      Face2FaceAddFriendActivity.h = paramInt2 * 1000;
    }
    if (!this.a.jdField_b_of_type_Boolean) {
      Face2FaceAddFriendActivity.c(this.a);
    }
    this.a.jdField_b_of_type_Boolean = true;
    if ((this.a.jdField_b_of_type_Int == 0) && (paramList != null) && (paramList.size() > 0)) {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      aonp localaonp;
      if (paramList.hasNext())
      {
        localaonp = (aonp)paramList.next();
        if (!this.a.jdField_a_of_type_JavaUtilList.contains(localaonp)) {}
      }
      else
      {
        Face2FaceAddFriendActivity.d(this.a);
        return;
      }
      this.a.jdField_a_of_type_JavaUtilList.add(localaonp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aomq
 * JD-Core Version:    0.7.0.1
 */