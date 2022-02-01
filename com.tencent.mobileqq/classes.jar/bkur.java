import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class bkur
  implements PluginManagerUpdater
{
  private aulr jdField_a_of_type_Aulr;
  private File jdField_a_of_type_JavaIoFile;
  
  public bkur(aulr paramaulr, File paramFile)
  {
    this.jdField_a_of_type_Aulr = paramaulr;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_Aulr.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_Aulr.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkur
 * JD-Core Version:    0.7.0.1
 */