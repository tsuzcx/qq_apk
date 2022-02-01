import com.tencent.qphone.base.util.QLog;

class bdds
  extends andd
{
  bdds(bddq parambddq) {}
  
  protected void onGetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "onGetSignInStatus isSucc = " + paramBoolean + ", troopUin = " + paramString1 + ", memberUin = " + paramString2);
    }
    bddq.a(this.a, paramBoolean, paramString1, paramString2, paramObject, paramInt);
  }
  
  protected void onSetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "onSetSignInStatus isSucc = " + paramBoolean + ", troopUin = " + paramString1 + ", memberUin = " + paramString2);
    }
    bddq.a(this.a, paramBoolean, paramString1, paramString2, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdds
 * JD-Core Version:    0.7.0.1
 */