import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class bjaz
  implements PluginManagerUpdater
{
  private asyw jdField_a_of_type_Asyw;
  private File jdField_a_of_type_JavaIoFile;
  
  public bjaz(asyw paramasyw, File paramFile)
  {
    this.jdField_a_of_type_Asyw = paramasyw;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Asyw.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Asyw.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjaz
 * JD-Core Version:    0.7.0.1
 */