package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RepeatedFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder>
  implements AbstractMessage.BuilderParent
{
  private AbstractMessage.BuilderParent a;
  private List<MType> b;
  private boolean c;
  private List<SingleFieldBuilderV3<MType, BType, IType>> d;
  private boolean e;
  private RepeatedFieldBuilderV3.MessageExternalList<MType, BType, IType> f;
  private RepeatedFieldBuilderV3.BuilderExternalList<MType, BType, IType> g;
  private RepeatedFieldBuilderV3.MessageOrBuilderExternalList<MType, BType, IType> h;
  
  public RepeatedFieldBuilderV3(List<MType> paramList, boolean paramBoolean1, AbstractMessage.BuilderParent paramBuilderParent, boolean paramBoolean2)
  {
    this.b = paramList;
    this.c = paramBoolean1;
    this.a = paramBuilderParent;
    this.e = paramBoolean2;
  }
  
  private MType a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return (AbstractMessage)this.b.get(paramInt);
    }
    localObject = (SingleFieldBuilderV3)((List)localObject).get(paramInt);
    if (localObject == null) {
      return (AbstractMessage)this.b.get(paramInt);
    }
    if (paramBoolean) {
      return ((SingleFieldBuilderV3)localObject).d();
    }
    return ((SingleFieldBuilderV3)localObject).c();
  }
  
  private void g()
  {
    if (!this.c)
    {
      this.b = new ArrayList(this.b);
      this.c = true;
    }
  }
  
  private void h()
  {
    if (this.d == null)
    {
      this.d = new ArrayList(this.b.size());
      int i = 0;
      while (i < this.b.size())
      {
        this.d.add(null);
        i += 1;
      }
    }
  }
  
  private void i()
  {
    if (this.e)
    {
      AbstractMessage.BuilderParent localBuilderParent = this.a;
      if (localBuilderParent != null)
      {
        localBuilderParent.a();
        this.e = false;
      }
    }
  }
  
  private void j()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((RepeatedFieldBuilderV3.MessageExternalList)localObject).a();
    }
    localObject = this.g;
    if (localObject != null) {
      ((RepeatedFieldBuilderV3.BuilderExternalList)localObject).a();
    }
    localObject = this.h;
    if (localObject != null) {
      ((RepeatedFieldBuilderV3.MessageOrBuilderExternalList)localObject).a();
    }
  }
  
  public MType a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public RepeatedFieldBuilderV3<MType, BType, IType> a(MType paramMType)
  {
    Internal.a(paramMType);
    g();
    this.b.add(paramMType);
    paramMType = this.d;
    if (paramMType != null) {
      paramMType.add(null);
    }
    i();
    j();
    return this;
  }
  
  public RepeatedFieldBuilderV3<MType, BType, IType> a(Iterable<? extends MType> paramIterable)
  {
    Object localObject = paramIterable.iterator();
    while (((Iterator)localObject).hasNext()) {
      Internal.a((AbstractMessage)((Iterator)localObject).next());
    }
    int i = -1;
    if ((paramIterable instanceof Collection))
    {
      localObject = (Collection)paramIterable;
      if (((Collection)localObject).size() == 0) {
        return this;
      }
      i = ((Collection)localObject).size();
    }
    g();
    if (i >= 0)
    {
      localObject = this.b;
      if ((localObject instanceof ArrayList)) {
        ((ArrayList)localObject).ensureCapacity(((List)localObject).size() + i);
      }
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      a((AbstractMessage)paramIterable.next());
    }
    i();
    j();
    return this;
  }
  
  public void a()
  {
    i();
  }
  
  public BType b(int paramInt)
  {
    h();
    SingleFieldBuilderV3 localSingleFieldBuilderV32 = (SingleFieldBuilderV3)this.d.get(paramInt);
    SingleFieldBuilderV3 localSingleFieldBuilderV31 = localSingleFieldBuilderV32;
    if (localSingleFieldBuilderV32 == null)
    {
      localSingleFieldBuilderV31 = new SingleFieldBuilderV3((AbstractMessage)this.b.get(paramInt), this, this.e);
      this.d.set(paramInt, localSingleFieldBuilderV31);
    }
    return localSingleFieldBuilderV31.e();
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  public IType c(int paramInt)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return (MessageOrBuilder)this.b.get(paramInt);
    }
    localObject = (SingleFieldBuilderV3)((List)localObject).get(paramInt);
    if (localObject == null) {
      return (MessageOrBuilder)this.b.get(paramInt);
    }
    return ((SingleFieldBuilderV3)localObject).f();
  }
  
  public boolean d()
  {
    return this.b.isEmpty();
  }
  
  public void e()
  {
    this.b = Collections.emptyList();
    this.c = false;
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SingleFieldBuilderV3 localSingleFieldBuilderV3 = (SingleFieldBuilderV3)((Iterator)localObject).next();
        if (localSingleFieldBuilderV3 != null) {
          localSingleFieldBuilderV3.b();
        }
      }
      this.d = null;
    }
    i();
    j();
  }
  
  public List<MType> f()
  {
    this.e = true;
    if ((!this.c) && (this.d == null)) {
      return this.b;
    }
    if (!this.c)
    {
      i = 0;
      while (i < this.b.size())
      {
        Message localMessage = (Message)this.b.get(i);
        SingleFieldBuilderV3 localSingleFieldBuilderV3 = (SingleFieldBuilderV3)this.d.get(i);
        if ((localSingleFieldBuilderV3 != null) && (localSingleFieldBuilderV3.d() != localMessage))
        {
          i = 0;
          break label100;
        }
        i += 1;
      }
      i = 1;
      label100:
      if (i != 0) {
        return this.b;
      }
    }
    g();
    int i = 0;
    while (i < this.b.size())
    {
      this.b.set(i, a(i, true));
      i += 1;
    }
    this.b = Collections.unmodifiableList(this.b);
    this.c = false;
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RepeatedFieldBuilderV3
 * JD-Core Version:    0.7.0.1
 */