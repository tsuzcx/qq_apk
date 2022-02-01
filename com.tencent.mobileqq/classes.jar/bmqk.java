import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class bmqk
  implements PluginManagerUpdater
{
  private avyr jdField_a_of_type_Avyr;
  private File jdField_a_of_type_JavaIoFile;
  
  public bmqk(avyr paramavyr, File paramFile)
  {
    this.jdField_a_of_type_Avyr = paramavyr;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Avyr.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Avyr.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqk
 * JD-Core Version:    0.7.0.1
 */