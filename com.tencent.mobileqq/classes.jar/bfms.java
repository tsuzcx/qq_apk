import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class bfms
  implements PluginManagerUpdater
{
  private aqjs jdField_a_of_type_Aqjs;
  private File jdField_a_of_type_JavaIoFile;
  
  public bfms(aqjs paramaqjs, File paramFile)
  {
    this.jdField_a_of_type_Aqjs = paramaqjs;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Aqjs.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Aqjs.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfms
 * JD-Core Version:    0.7.0.1
 */