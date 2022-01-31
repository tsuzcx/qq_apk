import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public abstract class bcfn<VH extends RecyclerView.ViewHolder, D extends bcdy>
  extends bceu<VH, D>
{
  public bcfn(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public abstract void a(D paramD);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfn
 * JD-Core Version:    0.7.0.1
 */