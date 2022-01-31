import android.content.ClipData;
import android.view.View;
import java.io.File;

public class bdae
{
  public ClipData a;
  public View a;
  File a;
  
  bdae(File paramFile, View paramView, ClipData paramClipData)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentClipData = paramClipData;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidContentClipData != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdae
 * JD-Core Version:    0.7.0.1
 */