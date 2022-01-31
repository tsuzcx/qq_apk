import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class amzo
  implements amzl
{
  amzo(amzn paramamzn, amzq paramamzq, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Amzq != null) {
      this.jdField_a_of_type_Amzq.a(amzn.a(this.jdField_a_of_type_Amzn, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, amzm paramamzm)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Amzq != null) {
      this.jdField_a_of_type_Amzq.a(paramamzm.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localamzm = (amzm)localIterator.next();
          if (!localamzm.jdField_a_of_type_JavaLangString.equals(paramamzm.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramamzm.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramamzm.jdField_a_of_type_Int == 6)
            {
              new File(paramamzm.c);
              amzr.a(paramamzm.c, amzh.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localamzm);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localamzm.jdField_a_of_type_JavaLangString);
              break;
              if (paramamzm.jdField_a_of_type_Int != 7) {
                break label268;
              }
              amzr.a(paramamzm.c, amzh.a(paramamzm.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramamzm.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Amzq != null) {
              this.jdField_a_of_type_Amzq.a(false);
            }
            this.jdField_a_of_type_Amzn.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          amzm localamzm;
          File localFile = new File(paramamzm.c);
          amzr.a(paramamzm.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramamzm.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Amzq != null) {
        this.jdField_a_of_type_Amzq.a(true);
      }
      this.jdField_a_of_type_Amzn.a();
      return;
    }
    if (this.jdField_a_of_type_Amzq != null) {
      this.jdField_a_of_type_Amzq.a(false);
    }
    this.jdField_a_of_type_Amzn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzo
 * JD-Core Version:    0.7.0.1
 */