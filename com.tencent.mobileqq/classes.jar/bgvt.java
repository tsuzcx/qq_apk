import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class bgvt
  implements PluginManagerUpdater
{
  private ardz jdField_a_of_type_Ardz;
  private File jdField_a_of_type_JavaIoFile;
  
  public bgvt(ardz paramardz, File paramFile)
  {
    this.jdField_a_of_type_Ardz = paramardz;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Ardz.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Ardz.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvt
 * JD-Core Version:    0.7.0.1
 */