import android.content.Context;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;

class aqmh
{
  private Context jdField_a_of_type_AndroidContentContext;
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private aqmi jdField_a_of_type_Aqmi;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public aqmh(aqmf paramaqmf, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      Log.d("Recorder", "release Recorder");
    }
    if (this.jdField_a_of_type_Aqmi != null) {
      this.jdField_a_of_type_Aqmi.a(paramInt, paramString);
    }
  }
  
  private boolean b()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(3);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioChannels(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSamplingRate(16000);
      this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.jdField_a_of_type_JavaIoFile.getPath());
      return false;
    }
    catch (Exception localException)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
        return true;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.d("MediaRecorder", "IllegalStateException preparing MediaRecorder: " + localIllegalStateException.getMessage());
        a(3, "prepare recorder exception=" + localIllegalStateException.getMessage());
        return false;
      }
      catch (IOException localIOException)
      {
        Log.d("MediaRecorder", "IOException preparing MediaRecorder: " + localIOException.getMessage());
        a(4, "  recorder io exception=" + localIOException.getMessage());
      }
      localException = localException;
      localException.printStackTrace();
      Log.d("MediaRecorder", "Exception prepareRecord: ");
      a(2, "init recorder   exception=" + localException.getMessage());
      return false;
    }
  }
  
  private void c()
  {
    if (b()) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
      this.jdField_a_of_type_Boolean = true;
      Log.d("Recorder", "Start Record");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(5, "recorder RuntimeException r=" + localRuntimeException.getMessage());
      Log.d("Recorder", "RuntimeException: start() is called immediately after stop()");
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_AndroidMediaMediaRecorder.getMaxAmplitude() * 100 / 32768;
    }
    return 0;
  }
  
  public void a()
  {
    Log.d("Recorder", "stopRecordSave");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      Log.d("Recorder", this.jdField_a_of_type_JavaIoFile.getPath());
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.d("Recorder", "RuntimeException: stop() is called immediately after start()");
      return;
    }
    finally
    {
      a(0, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, aqmi paramaqmi)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aqmi = paramaqmi;
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
        a(1, "status is exception!");
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      catch (RuntimeException paramString)
      {
        for (;;)
        {
          Log.d("PttRecorder", "RuntimeException: stop() is called immediately after start()");
          a();
        }
      }
    }
    c();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists())) {
      return this.jdField_a_of_type_JavaIoFile.delete();
    }
    return false;
  }
  
  public void b()
  {
    Log.d("Recorder", "stopRecordUnSave");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.d("Recorder", "RuntimeException: stop() is called immediately after start()");
        a();
        a(-1, "");
      }
    }
    finally
    {
      a(-1, "");
    }
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmh
 * JD-Core Version:    0.7.0.1
 */