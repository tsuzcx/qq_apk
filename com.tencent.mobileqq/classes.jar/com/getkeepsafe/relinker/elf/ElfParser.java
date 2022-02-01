package com.getkeepsafe.relinker.elf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ElfParser
  implements Elf, Closeable
{
  private final int jdField_a_of_type_Int = 1179403647;
  private final FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  
  public ElfParser(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      this.jdField_a_of_type_JavaNioChannelsFileChannel = new FileInputStream(paramFile).getChannel();
      return;
    }
    throw new IllegalArgumentException("File is null or does not exist");
  }
  
  private long a(Elf.Header paramHeader, long paramLong1, long paramLong2)
  {
    for (long l = 0L; l < paramLong1; l += 1L)
    {
      Elf.ProgramHeader localProgramHeader = paramHeader.a(l);
      if ((localProgramHeader.a == 1L) && (localProgramHeader.c <= paramLong2) && (paramLong2 <= localProgramHeader.c + localProgramHeader.d)) {
        return paramLong2 - localProgramHeader.c + localProgramHeader.b;
      }
    }
    paramHeader = new IllegalStateException("Could not map vma to file offset!");
    for (;;)
    {
      throw paramHeader;
    }
  }
  
  protected int a(ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramByteBuffer, paramLong, 2);
    return paramByteBuffer.getShort() & 0xFFFF;
  }
  
  protected long a(ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramByteBuffer, paramLong, 8);
    return paramByteBuffer.getLong();
  }
  
  public Elf.Header a()
  {
    this.jdField_a_of_type_JavaNioChannelsFileChannel.position(0L);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (b(localByteBuffer, 0L) == 1179403647L)
    {
      int i = a(localByteBuffer, 4L);
      boolean bool;
      if (a(localByteBuffer, 5L) == 2) {
        bool = true;
      } else {
        bool = false;
      }
      if (i == 1) {
        return new Elf32Header(bool, this);
      }
      if (i == 2) {
        return new Elf64Header(bool, this);
      }
      throw new IllegalStateException("Invalid class type!");
    }
    throw new IllegalArgumentException("Invalid ELF Magic!");
  }
  
  protected String a(ByteBuffer paramByteBuffer, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = a(paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
    return localStringBuilder.toString();
  }
  
  public List<String> a()
  {
    this.jdField_a_of_type_JavaNioChannelsFileChannel.position(0L);
    ArrayList localArrayList = new ArrayList();
    Elf.Header localHeader = a();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (localHeader.a) {
      localObject = ByteOrder.BIG_ENDIAN;
    } else {
      localObject = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order((ByteOrder)localObject);
    long l1 = localHeader.c;
    int i = 0;
    long l2 = l1;
    if (l1 == 65535L) {
      l2 = localHeader.a(0).a;
    }
    for (l1 = 0L; l1 < l2; l1 += 1L)
    {
      localObject = localHeader.a(l1);
      if (((Elf.ProgramHeader)localObject).a == 2L)
      {
        l1 = ((Elf.ProgramHeader)localObject).b;
        break label138;
      }
    }
    l1 = 0L;
    label138:
    if (l1 == 0L) {
      return Collections.unmodifiableList(localArrayList);
    }
    Object localObject = new ArrayList();
    long l3 = 0L;
    for (;;)
    {
      Elf.DynamicStructure localDynamicStructure = localHeader.a(l1, i);
      if (localDynamicStructure.a == 1L) {
        ((List)localObject).add(Long.valueOf(localDynamicStructure.b));
      } else if (localDynamicStructure.a == 5L) {
        l3 = localDynamicStructure.b;
      }
      i += 1;
      if (localDynamicStructure.a == 0L)
      {
        if (l3 != 0L)
        {
          l1 = a(localHeader, l2, l3);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(a(localByteBuffer, ((Long)((Iterator)localObject).next()).longValue() + l1));
          }
          return localArrayList;
        }
        throw new IllegalStateException("String table offset not found!");
      }
    }
  }
  
  protected short a(ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramByteBuffer, paramLong, 1);
    return (short)(paramByteBuffer.get() & 0xFF);
  }
  
  protected void a(ByteBuffer paramByteBuffer, long paramLong, int paramInt)
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    long l = 0L;
    while (l < paramInt)
    {
      int i = this.jdField_a_of_type_JavaNioChannelsFileChannel.read(paramByteBuffer, paramLong + l);
      if (i != -1) {
        l += i;
      } else {
        throw new EOFException();
      }
    }
    paramByteBuffer.position(0);
  }
  
  protected long b(ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramByteBuffer, paramLong, 4);
    return paramByteBuffer.getInt() & 0xFFFFFFFF;
  }
  
  public void close()
  {
    this.jdField_a_of_type_JavaNioChannelsFileChannel.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.ElfParser
 * JD-Core Version:    0.7.0.1
 */