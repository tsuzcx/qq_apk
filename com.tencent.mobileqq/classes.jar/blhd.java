import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment.OffscreenCaptureRunnable;
import java.util.ArrayList;
import java.util.List;

public class blhd
  extends AsyncTask<Void, Void, Void>
{
  public blhd(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  protected Void a(Void... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    AEVideoShelfEditFragment.a(this.a);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion()) {
      QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "init data doInBackground1---cost: ", Long.valueOf(l2 - l1) });
    }
    AEVideoShelfEditFragment.b(this.a);
    if (QLog.isDebugVersion()) {
      QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "init data doInBackground2---cost: ", Long.valueOf(System.currentTimeMillis() - l2) });
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    AEVideoShelfEditFragment.c(this.a);
    if (AEVideoShelfEditFragment.a(this.a).isEmpty())
    {
      bljn.c("AEVideoShelfEditFrag", "init NodeGroup Error!");
      return;
    }
    paramVoid = new ArrayList();
    int i = 0;
    while (i < AEVideoShelfEditFragment.a(this.a).size())
    {
      ShelfNode localShelfNode = new ShelfNode();
      localShelfNode.setCoverUri(((NodeGroup)AEVideoShelfEditFragment.a(this.a).get(i)).nodeCoverImage);
      paramVoid.add(localShelfNode);
      i += 1;
    }
    AEVideoShelfEditFragment.a(this.a, new blil(this.a.getActivity(), paramVoid, AEVideoShelfEditFragment.a(this.a).getVideoWidth(), AEVideoShelfEditFragment.a(this.a).getVideoHeight()));
    AEVideoShelfEditFragment.a(this.a).a(AEVideoShelfEditFragment.a(this.a).getMaterialPath());
    AEVideoShelfEditFragment.a(this.a).setAdapter(AEVideoShelfEditFragment.a(this.a));
    AEVideoShelfEditFragment.d(this.a);
    AEVideoShelfEditFragment.e(this.a);
    AEVideoShelfEditFragment.a(this.a, 0);
    new AEVideoShelfEditFragment.OffscreenCaptureRunnable(this.a, null).run();
  }
  
  protected void onPreExecute()
  {
    AEVideoShelfEditFragment.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhd
 * JD-Core Version:    0.7.0.1
 */