import com.tencent.qphone.base.util.QLog;

class bagn
  extends asvt
{
  bagn(bagl parambagl) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2) && (bagl.a(this.a) != null)) {
      bagl.b(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagn
 * JD-Core Version:    0.7.0.1
 */