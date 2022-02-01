import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

class blml
  implements ThreadExcutor.IThreadListener
{
  blml(blmi paramblmi) {}
  
  public void onAdded()
  {
    bmbx.a("AEPhotoListLogicBase", "onAdded--serialCompressVideos");
  }
  
  public void onPostRun()
  {
    bmbx.a("AEPhotoListLogicBase", "onPostRun--serialCompressVideos");
  }
  
  public void onPreRun()
  {
    bmbx.a("AEPhotoListLogicBase", "onPreRun--serialCompressVideos");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blml
 * JD-Core Version:    0.7.0.1
 */