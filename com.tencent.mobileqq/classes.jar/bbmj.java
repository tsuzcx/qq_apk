import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeTask;

public class bbmj
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
      ykq.b("FlowEdit_VideoFlowDecoder", "setSpeedType:" + paramInt);
      return;
    }
    ykq.d("FlowEdit_VideoFlowDecoder", "setSpeedType:" + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
    if (localVideoFlowDecodeTask != null)
    {
      ykq.d("FlowEdit_VideoFlowDecoder", "setPlayRange [" + paramLong1 + " ms, " + paramLong2 + " ms]");
      localVideoFlowDecodeTask.a(paramLong1, paramLong2);
      return;
    }
    ykq.d("FlowEdit_VideoFlowDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(bblh parambblh, bblb parambblb, bbli parambbli)
  {
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      ykq.b("FlowEdit_VideoFlowDecoder", "stopDecode before startDecode, current thread : %s", this.jdField_a_of_type_JavaLangThread.getName());
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      ykq.c("FlowEdit_VideoFlowDecoder", "startDecode, create decode runnable");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask = new VideoFlowDecodeTask(parambblh.a, parambblb, parambbli);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask.a(parambblh);
      parambblh = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeTask;
      parambblb = new StringBuilder().append("HWVideoDecoder-Thread-");
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(parambblh, i, 8);
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
      ykq.b("FlowEdit_VideoFlowDecoder", "pauseDecode");
      return;
    }
    ykq.d("FlowEdit_VideoFlowDecoder", "pauseDecode failed, can not find DecodeRunnable");
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
        ykq.b("FlowEdit_VideoFlowDecoder", "pauseDecode");
        return;
      }
    }
    ykq.d("FlowEdit_VideoFlowDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmj
 * JD-Core Version:    0.7.0.1
 */