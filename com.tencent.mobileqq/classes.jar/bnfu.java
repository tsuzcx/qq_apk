import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class bnfu
{
  private int jdField_a_of_type_Int;
  private final Class<? extends bmnh> jdField_a_of_type_JavaLangClass;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final int b;
  private final int c;
  
  private bnfu(int paramInt1, int paramInt2, int paramInt3, Class<? extends bmnh> paramClass)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  static bnfu a(int paramInt1, int paramInt2, int paramInt3, Class<? extends bmnh> paramClass)
  {
    return new bnfu(paramInt1, paramInt2, paramInt3, paramClass);
  }
  
  Class<? extends bmnh> a()
  {
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        LpReportInfo_pf00064.allReport(this.jdField_a_of_type_Int, this.b, localInteger.intValue());
        QZLog.d("QzoneEditPictureAndVide", 2, new Object[] { "performReport ", toString() + " with " + localInteger });
      }
    }
    LpReportInfo_pf00064.allReport(this.jdField_a_of_type_Int, this.b, this.c);
    QZLog.d("QzoneEditPictureAndVide", 2, "performReport " + toString());
  }
  
  void a(Set<Integer> paramSet)
  {
    this.jdField_a_of_type_JavaUtilSet.addAll(paramSet);
  }
  
  public String toString()
  {
    return "QzoneEditPictureReportModel{actionType=" + this.jdField_a_of_type_Int + ", subActionType=" + this.b + ", reserve=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfu
 * JD-Core Version:    0.7.0.1
 */