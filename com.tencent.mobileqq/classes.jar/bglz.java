import com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread.1;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class bglz
{
  private static bglz jdField_a_of_type_Bglz;
  private final Selector jdField_a_of_type_JavaNioChannelsSelector = Selector.open();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private bglz()
  {
    new Thread(new NioSelectorThread.1(this), "NioThread").start();
  }
  
  public static bglz a()
  {
    try
    {
      if (jdField_a_of_type_Bglz == null) {
        jdField_a_of_type_Bglz = new bglz();
      }
      return jdField_a_of_type_Bglz;
    }
    finally {}
  }
  
  private void a()
  {
    for (;;)
    {
      if (!this.jdField_a_of_type_JavaNioChannelsSelector.isOpen()) {
        return;
      }
      try
      {
        this.jdField_a_of_type_JavaNioChannelsSelector.select();
        Iterator localIterator = this.jdField_a_of_type_JavaNioChannelsSelector.selectedKeys().iterator();
        while (localIterator.hasNext())
        {
          SelectionKey localSelectionKey = (SelectionKey)localIterator.next();
          if (((bgma)localSelectionKey.attachment()).handle(localSelectionKey)) {
            localIterator.remove();
          }
        }
        if (!this.jdField_a_of_type_Boolean) {}
      }
      catch (IOException localIOException) {}
    }
    for (;;) {}
  }
  
  public void a(SelectableChannel paramSelectableChannel, int paramInt, bgma parambgma)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaNioChannelsSelector.wakeup();
      paramSelectableChannel.register(this.jdField_a_of_type_JavaNioChannelsSelector, paramInt, parambgma);
      return;
    }
    finally
    {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglz
 * JD-Core Version:    0.7.0.1
 */