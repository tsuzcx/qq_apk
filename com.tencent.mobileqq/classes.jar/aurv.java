import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aurv
  extends alxx
{
  aurv(auru paramauru) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onAddShieldList from nearby");
      }
      auru.a(this.a, 4113, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onDeleteShieldList from nearby");
      }
      auru.a(this.a, 4114, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aurv
 * JD-Core Version:    0.7.0.1
 */