import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class bgvc
  implements PluginManagerUpdater
{
  private ardx jdField_a_of_type_Ardx;
  private File jdField_a_of_type_JavaIoFile;
  
  public bgvc(ardx paramardx, File paramFile)
  {
    this.jdField_a_of_type_Ardx = paramardx;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Ardx.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Ardx.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvc
 * JD-Core Version:    0.7.0.1
 */