import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class bami
  extends Handler
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int = -1;
  private Message jdField_a_of_type_AndroidOsMessage;
  private bamd jdField_a_of_type_Bamd;
  private bame jdField_a_of_type_Bame;
  private bamh jdField_a_of_type_Bamh = new bamh(null);
  private bamj jdField_a_of_type_Bamj = new bamj(this, null);
  private bamk jdField_a_of_type_Bamk = new bamk(this, null);
  private ArrayList<Message> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<bamd, baml> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private baml[] jdField_a_of_type_ArrayOfBaml;
  private int jdField_b_of_type_Int;
  private bamd jdField_b_of_type_Bamd;
  private boolean jdField_b_of_type_Boolean;
  private baml[] jdField_b_of_type_ArrayOfBaml;
  private boolean c;
  
  private bami(Looper paramLooper, bame parambame)
  {
    super(paramLooper);
    this.jdField_a_of_type_Bame = parambame;
    a(this.jdField_a_of_type_Bamj, null);
    a(this.jdField_a_of_type_Bamk, null);
  }
  
  private final int a()
  {
    int k = this.jdField_a_of_type_Int + 1;
    int i = this.jdField_b_of_type_Int - 1;
    int j = k;
    while (i >= 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("moveTempStackToStateStack: i=" + i + ",j=" + j);
      }
      this.jdField_a_of_type_ArrayOfBaml[j] = this.jdField_b_of_type_ArrayOfBaml[i];
      j += 1;
      i -= 1;
    }
    this.jdField_a_of_type_Int = (j - 1);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("moveTempStackToStateStack: X mStateStackTop=" + this.jdField_a_of_type_Int + ",startingIndex=" + k + ",Top=" + this.jdField_a_of_type_ArrayOfBaml[this.jdField_a_of_type_Int].jdField_a_of_type_Bamd.a());
    }
    return k;
  }
  
  private final baly a()
  {
    return this.jdField_a_of_type_ArrayOfBaml[this.jdField_a_of_type_Int].jdField_a_of_type_Bamd;
  }
  
  private final bamd a(Message paramMessage)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfBaml[this.jdField_a_of_type_Int];
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("processMsg: " + ((baml)localObject2).jdField_a_of_type_Bamd.a());
    }
    Object localObject1 = localObject2;
    if (a(paramMessage)) {
      a(this.jdField_a_of_type_Bamk);
    }
    while (localObject2 != null)
    {
      return ((baml)localObject2).jdField_a_of_type_Bamd;
      do
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Bame.a("processMsg: " + ((baml)localObject2).jdField_a_of_type_Bamd.a());
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1.jdField_a_of_type_Bamd.a(paramMessage)) {
          break;
        }
        localObject2 = localObject1.jdField_a_of_type_Baml;
      } while (localObject2 != null);
      this.jdField_a_of_type_Bame.b(paramMessage);
    }
    return null;
  }
  
  private final baml a(bamd parambamd)
  {
    this.jdField_b_of_type_Int = 0;
    parambamd = (baml)this.jdField_a_of_type_JavaUtilHashMap.get(parambamd);
    Object localObject;
    do
    {
      localObject = this.jdField_b_of_type_ArrayOfBaml;
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (i + 1);
      localObject[i] = parambamd;
      localObject = parambamd.jdField_a_of_type_Baml;
      if (localObject == null) {
        break;
      }
      parambamd = (bamd)localObject;
    } while (!((baml)localObject).jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.jdField_b_of_type_Int + ",curStateInfo: " + localObject);
    }
    return localObject;
  }
  
  private final baml a(bamd parambamd1, bamd parambamd2)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_Bame;
      StringBuilder localStringBuilder = new StringBuilder().append("addStateInternal: E state=").append(parambamd1.a()).append(",parent=");
      if (parambamd2 == null)
      {
        localObject1 = "";
        ((bame)localObject2).a((String)localObject1);
      }
    }
    else
    {
      if (parambamd2 == null) {
        break label216;
      }
      localObject1 = (baml)this.jdField_a_of_type_JavaUtilHashMap.get(parambamd2);
      if (localObject1 != null) {
        break label211;
      }
      parambamd2 = a(parambamd2, null);
    }
    for (;;)
    {
      localObject2 = (baml)this.jdField_a_of_type_JavaUtilHashMap.get(parambamd1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new baml(this, null);
        this.jdField_a_of_type_JavaUtilHashMap.put(parambamd1, localObject1);
      }
      if ((((baml)localObject1).jdField_a_of_type_Baml != null) && (((baml)localObject1).jdField_a_of_type_Baml != parambamd2))
      {
        throw new RuntimeException("state already added");
        localObject1 = parambamd2.a();
        break;
      }
      ((baml)localObject1).jdField_a_of_type_Bamd = parambamd1;
      ((baml)localObject1).jdField_a_of_type_Baml = parambamd2;
      ((baml)localObject1).jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("addStateInternal: X stateInfo: " + localObject1);
      }
      return localObject1;
      label211:
      parambamd2 = (bamd)localObject1;
      continue;
      label216:
      parambamd2 = null;
    }
  }
  
  private final void a()
  {
    if (bame.a(this.jdField_a_of_type_Bame) != null)
    {
      getLooper().quit();
      bame.a(this.jdField_a_of_type_Bame, null);
    }
    bame.a(this.jdField_a_of_type_Bame, null);
    this.jdField_a_of_type_Bame = null;
    this.jdField_a_of_type_AndroidOsMessage = null;
    this.jdField_a_of_type_Bamh.a();
    this.jdField_a_of_type_ArrayOfBaml = null;
    this.jdField_b_of_type_ArrayOfBaml = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Bamd = null;
    this.jdField_b_of_type_Bamd = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void a(int paramInt)
  {
    while (paramInt <= this.jdField_a_of_type_Int)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("invokeEnterMethods: " + this.jdField_a_of_type_ArrayOfBaml[paramInt].jdField_a_of_type_Bamd.a());
      }
      this.jdField_a_of_type_ArrayOfBaml[paramInt].jdField_a_of_type_Bamd.a();
      this.jdField_a_of_type_ArrayOfBaml[paramInt].jdField_a_of_type_Boolean = true;
      paramInt += 1;
    }
  }
  
  private final void a(Message paramMessage)
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("deferMessage: msg=" + paramMessage.what);
    }
    Message localMessage = obtainMessage();
    localMessage.copyFrom(paramMessage);
    this.jdField_a_of_type_JavaUtilArrayList.add(localMessage);
  }
  
  private final void a(baly parambaly)
  {
    this.jdField_b_of_type_Bamd = ((bamd)parambaly);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("transitionTo: destState=" + this.jdField_b_of_type_Bamd.a());
    }
  }
  
  private final void a(bamd parambamd)
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("setInitialState: initialState=" + parambamd.a());
    }
    this.jdField_a_of_type_Bamd = parambamd;
  }
  
  private void a(bamd parambamd, Message paramMessage)
  {
    bamd localbamd = this.jdField_a_of_type_ArrayOfBaml[this.jdField_a_of_type_Int].jdField_a_of_type_Bamd;
    int i;
    if ((this.jdField_a_of_type_Bame.a(this.jdField_a_of_type_AndroidOsMessage)) && (paramMessage.obj != jdField_a_of_type_JavaLangObject))
    {
      i = 1;
      if (!this.jdField_a_of_type_Bamh.a()) {
        break label159;
      }
      if (this.jdField_b_of_type_Bamd != null) {
        this.jdField_a_of_type_Bamh.a(this.jdField_a_of_type_Bame, this.jdField_a_of_type_AndroidOsMessage, this.jdField_a_of_type_Bame.a(this.jdField_a_of_type_AndroidOsMessage), parambamd, localbamd, this.jdField_b_of_type_Bamd);
      }
    }
    for (;;)
    {
      parambamd = this.jdField_b_of_type_Bamd;
      paramMessage = parambamd;
      if (parambamd == null) {
        break label206;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Bame.a("handleMessage: new destination call exit/enter");
        }
        a(a(parambamd));
        a(a());
        c();
        if (parambamd == this.jdField_b_of_type_Bamd) {
          break;
        }
        parambamd = this.jdField_b_of_type_Bamd;
      }
      i = 0;
      break;
      label159:
      if (i != 0) {
        this.jdField_a_of_type_Bamh.a(this.jdField_a_of_type_Bame, this.jdField_a_of_type_AndroidOsMessage, this.jdField_a_of_type_Bame.a(this.jdField_a_of_type_AndroidOsMessage), parambamd, localbamd, this.jdField_b_of_type_Bamd);
      }
    }
    this.jdField_b_of_type_Bamd = null;
    paramMessage = parambamd;
    label206:
    if (paramMessage != null)
    {
      if (paramMessage != this.jdField_a_of_type_Bamk) {
        break label230;
      }
      this.jdField_a_of_type_Bame.b();
      a();
    }
    label230:
    while (paramMessage != this.jdField_a_of_type_Bamj) {
      return;
    }
    this.jdField_a_of_type_Bame.a();
  }
  
  private final void a(baml parambaml)
  {
    while ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ArrayOfBaml[this.jdField_a_of_type_Int] != parambaml))
    {
      bamd localbamd = this.jdField_a_of_type_ArrayOfBaml[this.jdField_a_of_type_Int].jdField_a_of_type_Bamd;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("invokeExitMethods: " + localbamd.a());
      }
      localbamd.b();
      this.jdField_a_of_type_ArrayOfBaml[this.jdField_a_of_type_Int].jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int -= 1;
    }
  }
  
  private final boolean a(Message paramMessage)
  {
    return (paramMessage.what == -1) && (paramMessage.obj == jdField_a_of_type_JavaLangObject);
  }
  
  private final void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("completeConstruction: E");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      baml localbaml = (baml)localIterator.next();
      j = 0;
      while (localbaml != null)
      {
        localbaml = localbaml.jdField_a_of_type_Baml;
        j += 1;
      }
      if (i >= j) {
        break label168;
      }
    }
    for (;;)
    {
      i = j;
      break;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("completeConstruction: maxDepth=" + i);
      }
      this.jdField_a_of_type_ArrayOfBaml = new baml[i];
      this.jdField_b_of_type_ArrayOfBaml = new baml[i];
      d();
      sendMessageAtFrontOfQueue(obtainMessage(-2, jdField_a_of_type_JavaLangObject));
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("completeConstruction: X");
      }
      return;
      label168:
      j = i;
    }
  }
  
  private final void c()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      Message localMessage = (Message)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
      }
      sendMessageAtFrontOfQueue(localMessage);
      i -= 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private final void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("setupInitialStateStack: E mInitialState=" + this.jdField_a_of_type_Bamd.a());
    }
    baml localbaml = (baml)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Bamd);
    for (this.jdField_b_of_type_Int = 0; localbaml != null; this.jdField_b_of_type_Int += 1)
    {
      this.jdField_b_of_type_ArrayOfBaml[this.jdField_b_of_type_Int] = localbaml;
      localbaml = localbaml.jdField_a_of_type_Baml;
    }
    this.jdField_a_of_type_Int = -1;
    a();
  }
  
  private final void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Bame.a("quit:");
    }
    sendMessage(obtainMessage(-1, jdField_a_of_type_JavaLangObject));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    bamd localbamd;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bame.a("handleMessage: E msg.what=" + paramMessage.what);
      }
      this.jdField_a_of_type_AndroidOsMessage = paramMessage;
      localbamd = null;
      if (!this.c) {
        break label95;
      }
      localbamd = a(paramMessage);
    }
    for (;;)
    {
      a(localbamd, paramMessage);
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bame != null)) {
        this.jdField_a_of_type_Bame.a("handleMessage: X");
      }
      return;
      label95:
      if ((this.c) || (this.jdField_a_of_type_AndroidOsMessage.what != -2) || (this.jdField_a_of_type_AndroidOsMessage.obj != jdField_a_of_type_JavaLangObject)) {
        break;
      }
      this.c = true;
      a(0);
    }
    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bami
 * JD-Core Version:    0.7.0.1
 */