import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class apno
{
  private apko jdField_a_of_type_Apko = new apko();
  private apku jdField_a_of_type_Apku;
  private apkw jdField_a_of_type_Apkw;
  private boolean jdField_a_of_type_Boolean = true;
  
  public apno()
  {
    this.jdField_a_of_type_Apko.a(new apkq());
    this.jdField_a_of_type_Apku = new apku();
    this.jdField_a_of_type_Apku.a(this.jdField_a_of_type_Apko);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Apko != null) && (this.jdField_a_of_type_Apkw != null))
    {
      localColorNote = this.jdField_a_of_type_Apkw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Apko.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = aplm.a(localColorNote);
        this.jdField_a_of_type_Apko.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onResume: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onResume: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void a(apko paramapko)
  {
    this.jdField_a_of_type_Apko = paramapko;
  }
  
  public void a(apkq paramapkq)
  {
    if (this.jdField_a_of_type_Apko != null) {
      this.jdField_a_of_type_Apko.a(paramapkq);
    }
  }
  
  public void a(apkw paramapkw)
  {
    this.jdField_a_of_type_Apkw = paramapkw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Apko != null) && (this.jdField_a_of_type_Apkw != null))
    {
      localColorNote = this.jdField_a_of_type_Apkw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Apko.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = aplm.a(localColorNote);
        this.jdField_a_of_type_Apko.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onPause: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onPause: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Apkw != null) && (this.jdField_a_of_type_Apko != null) && (this.jdField_a_of_type_Apku != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Apkw.getColorNote();
      localObject = localColorNote;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteStateNotice", 1, localException, new Object[0]);
        continue;
        int i = 0;
      }
    }
    if ((localObject != null) && (a(localObject.getServiceType())))
    {
      i = 1;
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Apko.a(localObject.getServiceType(), localObject.getSubType())))
      {
        aplm.a(localObject);
        this.jdField_a_of_type_Apku.a(localObject);
      }
      return;
    }
  }
  
  public void c()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apno
 * JD-Core Version:    0.7.0.1
 */