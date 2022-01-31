import com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread.1;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class bels
{
  private static bels jdField_a_of_type_Bels;
  private final Selector jdField_a_of_type_JavaNioChannelsSelector = Selector.open();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private bels()
  {
    new Thread(new NioSelectorThread.1(this), "NioThread").start();
  }
  
  public static bels a()
  {
    try
    {
      if (jdField_a_of_type_Bels == null) {
        jdField_a_of_type_Bels = new bels();
      }
      return jdField_a_of_type_Bels;
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
          if (((belt)localSelectionKey.attachment()).handle(localSelectionKey)) {
            localIterator.remove();
          }
        }
        if (!this.jdField_a_of_type_Boolean) {}
      }
      catch (IOException localIOException) {}
    }
    for (;;) {}
  }
  
  public void a(SelectableChannel paramSelectableChannel, int paramInt, belt parambelt)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaNioChannelsSelector.wakeup();
      paramSelectableChannel.register(this.jdField_a_of_type_JavaNioChannelsSelector, paramInt, parambelt);
      return;
    }
    finally
    {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bels
 * JD-Core Version:    0.7.0.1
 */