import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aoai
{
  private anxo jdField_a_of_type_Anxo = new anxo();
  private anxu jdField_a_of_type_Anxu;
  private anxw jdField_a_of_type_Anxw;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aoai()
  {
    this.jdField_a_of_type_Anxo.a(new anxq());
    this.jdField_a_of_type_Anxu = new anxu();
    this.jdField_a_of_type_Anxu.a(this.jdField_a_of_type_Anxo);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Anxo != null) && (this.jdField_a_of_type_Anxw != null))
    {
      localColorNote = this.jdField_a_of_type_Anxw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Anxo.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = anyi.a(localColorNote);
        this.jdField_a_of_type_Anxo.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
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
  
  public void a(anxo paramanxo)
  {
    this.jdField_a_of_type_Anxo = paramanxo;
  }
  
  public void a(anxq paramanxq)
  {
    if (this.jdField_a_of_type_Anxo != null) {
      this.jdField_a_of_type_Anxo.a(paramanxq);
    }
  }
  
  public void a(anxw paramanxw)
  {
    this.jdField_a_of_type_Anxw = paramanxw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Anxo != null) && (this.jdField_a_of_type_Anxw != null))
    {
      localColorNote = this.jdField_a_of_type_Anxw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Anxo.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = anyi.a(localColorNote);
        this.jdField_a_of_type_Anxo.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
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
    if ((this.jdField_a_of_type_Anxw != null) && (this.jdField_a_of_type_Anxo != null) && (this.jdField_a_of_type_Anxu != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Anxw.getColorNote();
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
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Anxo.a(localObject.getServiceType(), localObject.getSubType())))
      {
        anyi.a(localObject);
        this.jdField_a_of_type_Anxu.a(localObject);
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
 * Qualified Name:     aoai
 * JD-Core Version:    0.7.0.1
 */