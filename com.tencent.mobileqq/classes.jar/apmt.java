import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class apmt
  implements apmq
{
  apmt(apms paramapms, apmv paramapmv, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Apmv != null) {
      this.jdField_a_of_type_Apmv.a(apms.a(this.jdField_a_of_type_Apms, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, apmr paramapmr)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Apmv != null) {
      this.jdField_a_of_type_Apmv.a(paramapmr.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localapmr = (apmr)localIterator.next();
          if (!localapmr.jdField_a_of_type_JavaLangString.equals(paramapmr.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramapmr.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramapmr.jdField_a_of_type_Int == 6)
            {
              new File(paramapmr.c);
              apmw.a(paramapmr.c, apmm.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localapmr);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localapmr.jdField_a_of_type_JavaLangString);
              break;
              if (paramapmr.jdField_a_of_type_Int != 7) {
                break label268;
              }
              apmw.a(paramapmr.c, apmm.a(paramapmr.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramapmr.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Apmv != null) {
              this.jdField_a_of_type_Apmv.a(false);
            }
            this.jdField_a_of_type_Apms.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          apmr localapmr;
          File localFile = new File(paramapmr.c);
          apmw.a(paramapmr.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramapmr.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Apmv != null) {
        this.jdField_a_of_type_Apmv.a(true);
      }
      this.jdField_a_of_type_Apms.a();
      return;
    }
    if (this.jdField_a_of_type_Apmv != null) {
      this.jdField_a_of_type_Apmv.a(false);
    }
    this.jdField_a_of_type_Apms.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmt
 * JD-Core Version:    0.7.0.1
 */