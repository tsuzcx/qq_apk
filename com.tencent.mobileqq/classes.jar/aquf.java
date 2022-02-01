import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aquf
{
  private aqrf jdField_a_of_type_Aqrf = new aqrf();
  private aqrl jdField_a_of_type_Aqrl;
  private aqrn jdField_a_of_type_Aqrn;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aquf()
  {
    this.jdField_a_of_type_Aqrf.a(new aqrh());
    this.jdField_a_of_type_Aqrl = new aqrl();
    this.jdField_a_of_type_Aqrl.a(this.jdField_a_of_type_Aqrf);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aqrf != null) && (this.jdField_a_of_type_Aqrn != null))
    {
      localColorNote = this.jdField_a_of_type_Aqrn.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqrf.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = aqsd.a(localColorNote);
        this.jdField_a_of_type_Aqrf.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
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
  
  public void a(aqrf paramaqrf)
  {
    this.jdField_a_of_type_Aqrf = paramaqrf;
  }
  
  public void a(aqrh paramaqrh)
  {
    if (this.jdField_a_of_type_Aqrf != null) {
      this.jdField_a_of_type_Aqrf.a(paramaqrh);
    }
  }
  
  public void a(aqrn paramaqrn)
  {
    this.jdField_a_of_type_Aqrn = paramaqrn;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqrf != null) && (this.jdField_a_of_type_Aqrn != null))
    {
      localColorNote = this.jdField_a_of_type_Aqrn.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqrf.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = aqsd.a(localColorNote);
        this.jdField_a_of_type_Aqrf.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
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
    if ((this.jdField_a_of_type_Aqrn != null) && (this.jdField_a_of_type_Aqrf != null) && (this.jdField_a_of_type_Aqrl != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqrn.getColorNote();
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
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Aqrf.a(localObject.getServiceType(), localObject.getSubType())))
      {
        aqsd.a(localObject);
        this.jdField_a_of_type_Aqrl.a(localObject);
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
 * Qualified Name:     aquf
 * JD-Core Version:    0.7.0.1
 */