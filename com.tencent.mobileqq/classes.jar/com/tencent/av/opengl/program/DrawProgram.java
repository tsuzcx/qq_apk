package com.tencent.av.opengl.program;

import lhc;
import lhd;
import lhe;

public class DrawProgram
  extends TextureProgram
{
  public DrawProgram()
  {
    super("uniform mat4 uMatrix;attribute vec2 aPosition;void main() {vec4 pos = vec4 (aPosition, 0.0, 1.0);gl_Position  = uMatrix * pos;}", "precision mediump float;uniform vec4 uColor;void main() {gl_FragColor = uColor;}", new lhd[] { new lhc("aPosition"), new lhe("uMatrix"), new lhe("uColor") }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.opengl.program.DrawProgram
 * JD-Core Version:    0.7.0.1
 */