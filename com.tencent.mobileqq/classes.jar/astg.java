import com.tencent.qphone.base.util.QLog;

class astg
  extends amwl
{
  astg(astb paramastb) {}
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (astb.a(this.a)) {
        aszk.a(2131693915);
      }
      astb.a(this.a, false);
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 2, "PC offline!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astg
 * JD-Core Version:    0.7.0.1
 */