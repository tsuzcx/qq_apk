import com.tencent.tavcut.TAVCut.Callback;

class bmdc
  implements TAVCut.Callback
{
  bmdc(bmdb parambmdb) {}
  
  public void onDone(int paramInt)
  {
    bmbx.b("AEEditorProcessManager", "TAVCut init ret code = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdc
 * JD-Core Version:    0.7.0.1
 */