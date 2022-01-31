import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;

public abstract interface bgso
{
  public abstract void onQueryCallback(ArrayList<WadlResult> paramArrayList);
  
  public abstract void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList);
  
  public abstract void onWadlTaskStatusChanged(WadlResult paramWadlResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgso
 * JD-Core Version:    0.7.0.1
 */