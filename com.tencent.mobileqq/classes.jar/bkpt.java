import com.tencent.qphone.base.util.QLog;

class bkpt
  extends bjde
{
  bkpt(bkps parambkps) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      bkps.a(this.a, true);
      bkps.a(this.a);
      return;
    }
    QLog.i("EditPicQzComment", 2, "download music fail" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpt
 * JD-Core Version:    0.7.0.1
 */