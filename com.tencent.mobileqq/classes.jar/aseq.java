import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aseq
  extends ajry
{
  aseq(asep paramasep) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onAddShieldList from nearby");
      }
      asep.a(this.a, 4113, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onDeleteShieldList from nearby");
      }
      asep.a(this.a, 4114, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aseq
 * JD-Core Version:    0.7.0.1
 */