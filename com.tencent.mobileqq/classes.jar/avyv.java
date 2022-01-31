import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeTask;

public class avyv
{
  private int jdField_a_of_type_Int;
  private VideoFlowDecodeTask jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
  private Thread jdField_a_of_type_JavaLangThread;
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    this.jdField_a_of_type_JavaLangThread = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask = null;
  }
  
  public void a(int paramInt)
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
    if (localVideoFlowDecodeTask != null)
    {
      localVideoFlowDecodeTask.a(paramInt);
      veg.b("FlowEdit_VideoFlowDecoder", "setSpeedType:" + paramInt);
      return;
    }
    veg.d("FlowEdit_VideoFlowDecoder", "setSpeedType:" + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
    if (localVideoFlowDecodeTask != null)
    {
      veg.d("FlowEdit_VideoFlowDecoder", "setPlayRange [" + paramLong1 + " ms, " + paramLong2 + " ms]");
      localVideoFlowDecodeTask.a(paramLong1, paramLong2);
      return;
    }
    veg.d("FlowEdit_VideoFlowDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(avxt paramavxt, avxn paramavxn, avxu paramavxu)
  {
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      veg.b("FlowEdit_VideoFlowDecoder", "stopDecode before startDecode, current thread : %s", this.jdField_a_of_type_JavaLangThread.getName());
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      veg.c("FlowEdit_VideoFlowDecoder", "startDecode, create decode runnable");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask = new VideoFlowDecodeTask(paramavxt.a, paramavxn, paramavxu);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask.a(paramavxt);
      paramavxt = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
      paramavxn = new StringBuilder().append("HWVideoDecoder-Thread-");
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(paramavxt, i, 8);
      this.jdField_a_of_type_JavaLangThread.start();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
    if (localVideoFlowDecodeTask != null)
    {
      localVideoFlowDecodeTask.jdField_a_of_type_Boolean = true;
      veg.b("FlowEdit_VideoFlowDecoder", "pauseDecode");
      return;
    }
    veg.d("FlowEdit_VideoFlowDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void c()
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
    if (localVideoFlowDecodeTask != null)
    {
      localVideoFlowDecodeTask.jdField_a_of_type_Boolean = false;
      synchronized (localVideoFlowDecodeTask.jdField_a_of_type_JavaLangObject)
      {
        localVideoFlowDecodeTask.jdField_a_of_type_JavaLangObject.notifyAll();
        veg.b("FlowEdit_VideoFlowDecoder", "pauseDecode");
        return;
      }
    }
    veg.d("FlowEdit_VideoFlowDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyv
 * JD-Core Version:    0.7.0.1
 */