import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class blpi
  implements PluginManagerUpdater
{
  private avgo jdField_a_of_type_Avgo;
  private File jdField_a_of_type_JavaIoFile;
  
  public blpi(avgo paramavgo, File paramFile)
  {
    this.jdField_a_of_type_Avgo = paramavgo;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Avgo.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Avgo.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpi
 * JD-Core Version:    0.7.0.1
 */