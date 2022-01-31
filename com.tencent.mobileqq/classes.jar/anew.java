import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave;

public class anew
  implements Runnable
{
  public anew(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    EditVideoSave localEditVideoSave = this.a;
    localEditVideoSave.jdField_a_of_type_Int += this.a.b;
    if (this.a.jdField_a_of_type_Int > 99)
    {
      this.a.jdField_a_of_type_Int = 99;
      this.a.a(this.a.jdField_a_of_type_Int);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_Int);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anew
 * JD-Core Version:    0.7.0.1
 */