import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class biws
  implements PluginManagerUpdater
{
  private asun jdField_a_of_type_Asun;
  private File jdField_a_of_type_JavaIoFile;
  
  public biws(asun paramasun, File paramFile)
  {
    this.jdField_a_of_type_Asun = paramasun;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Asun.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Asun.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biws
 * JD-Core Version:    0.7.0.1
 */