import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class aojr
  implements aojo
{
  aojr(aojq paramaojq, aojt paramaojt, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Aojt != null) {
      this.jdField_a_of_type_Aojt.a(aojq.a(this.jdField_a_of_type_Aojq, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, aojp paramaojp)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_Aojt != null) {
      this.jdField_a_of_type_Aojt.a(paramaojp.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localaojp = (aojp)localIterator.next();
          if (!localaojp.jdField_a_of_type_JavaLangString.equals(paramaojp.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramaojp.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramaojp.jdField_a_of_type_Int == 6)
            {
              new File(paramaojp.c);
              aoju.a(paramaojp.c, aojk.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localaojp);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localaojp.jdField_a_of_type_JavaLangString);
              break;
              if (paramaojp.jdField_a_of_type_Int != 7) {
                break label268;
              }
              aoju.a(paramaojp.c, aojk.a(paramaojp.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramaojp.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_Aojt != null) {
              this.jdField_a_of_type_Aojt.a(false);
            }
            this.jdField_a_of_type_Aojq.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          aojp localaojp;
          File localFile = new File(paramaojp.c);
          aoju.a(paramaojp.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramaojp.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_Aojt != null) {
        this.jdField_a_of_type_Aojt.a(true);
      }
      this.jdField_a_of_type_Aojq.a();
      return;
    }
    if (this.jdField_a_of_type_Aojt != null) {
      this.jdField_a_of_type_Aojt.a(false);
    }
    this.jdField_a_of_type_Aojq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojr
 * JD-Core Version:    0.7.0.1
 */