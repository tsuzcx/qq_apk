import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class bmga
  implements PluginManagerUpdater
{
  private avrm jdField_a_of_type_Avrm;
  private File jdField_a_of_type_JavaIoFile;
  
  public bmga(avrm paramavrm, File paramFile)
  {
    this.jdField_a_of_type_Avrm = paramavrm;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Avrm.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Avrm.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmga
 * JD-Core Version:    0.7.0.1
 */